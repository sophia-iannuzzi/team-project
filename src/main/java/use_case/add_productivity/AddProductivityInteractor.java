package use_case.add_productivity;

import entities.CognitiveData;
import use_case.data_access.ProductivityDataAccessInterface;
import java.time.LocalDate;

public class AddProductivityInteractor implements AddProductivityDateInputBoundary, AddProductivityInputBoundary{
    private final ProductivityDataAccessInterface dataAccessInterface;
    private final AddProductivityOutputBoundary presenter;

    /**
     * The class constructor
     */
    public AddProductivityInteractor(ProductivityDataAccessInterface productivityDataAccessInterface, AddProductivityOutputBoundary addProductivityOutputBoundary) {
        this.dataAccessInterface = productivityDataAccessInterface;
        this.presenter = addProductivityOutputBoundary;
    }

    @Override
    public void execute(AddProductivityDateInputData addProductivityDateInputData){
        //Get the input data from our InputData object
        final String username = addProductivityDateInputData.getUsername();
        final String string_date = addProductivityDateInputData.getDate();

        // Check that the date actually exists
        String[] date_break_down = string_date.split("/");

        // If the date does not follow the structure of a date in any way, ask them to retry
        if (date_break_down.length != 3) {
            presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
            return; // Ensure code stops executing here
        }
        else {
            // There are three items separated by / in the list
            // Check that they are all integers
            int[] date_break_down_ints = new int[3];
            try {
                for (int i = 0; i < 3; i +=1) {
                    date_break_down_ints[i] = Integer.parseInt(date_break_down[i]); // Convert the string of ints into a list of ints
                }
            }
            catch (NumberFormatException| NullPointerException e){
                // This means that they did not enter a list of integers
                presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
                return; // stop running the execution so that the user can retry putting in a date.
            }

            // Now we have a list of three ints that should be in the format (date; month; year)
            // We will check that this is the case

            //Check that the year is valid (Because the program is being used in 2026, we aren't going to have them add
            // data that is from several years ago
            if (date_break_down_ints[2] < 2026 || LocalDate.now().getYear() < date_break_down_ints[2]) {
                // This means that the date they are adding their productivity rating for a year before the program was
                // reated, or they are adding their rating for a time that is in the future
                presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
            } else if (date_break_down_ints[1] < 1 || date_break_down_ints[1] > 12) {
                // The month value that they added falls outside the range of [1, 12]
                presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
            } else if (date_break_down_ints[0] < 1 || date_break_down_ints[0] > 31) {
                // The date they have added falls outside the range of [1, 31]
                presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
            } else if (date_break_down_ints[1] == 2 && date_break_down_ints[0] > 29) {
                // The date they have added for February falls outside [1, 29] --> non gap years handled later
                presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
            } else if (date_break_down_ints[1] == 2 && date_break_down_ints[2]%4 != 0 && date_break_down_ints[0] > 28) {
                // The date they have added for February falls outside [1, 28] for non gap years
                presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
            } else if ((date_break_down_ints[1] == 4 || date_break_down_ints[1] == 6 || date_break_down_ints[1] == 9 ||
                    date_break_down_ints[1] == 11) && date_break_down_ints[0] > 30) {
                // They have entered an invalid date for a month that has 30 days
                presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
            } else {
                // Turn this date to a LocalDate object
                LocalDate date = LocalDate.of(date_break_down_ints[2], date_break_down_ints[1], date_break_down_ints[0]);

                // The date is correctly formatted - now we can check if there is a current rating entry for this date in
                // the cognitive data access object
                CognitiveData[] cogData = this.dataAccessInterface.getCognitiveData(username);

                // Check if there are any entries for the date for that user
                for (CognitiveData cognitiveData: cogData){
                    if (cognitiveData.getDate().equals(date)) {
                        // There is a cognitive data row in the database for this user on this date
                        if (cognitiveData.getProductivityRating() != 0.0){
                            // There is already a productivity score for the day
                            presenter.prepareExistingProductivityView("You already have added a productivity rating" +
                                    "of " + cognitiveData.getProductivityRating() +" for "+ date.toString());
                            return;
                        }
                    }
                }

                // If we have reached this part of the code, then the date is correctly formatted and there is not an
                // existing productivity value for the date, so we can continue to AddProductivity
                presenter.prepareAddProductivityView(date, username);
            }
        }
    }

    @Override
    public void execute(AddProductivityInputData productivityInputData){
        //Get the input data from our InputData object
        final String username = productivityInputData.getUsername();
        final LocalDate date = productivityInputData.getDate();
        final String string_rating = productivityInputData.getRating();

        // Check they inputted an answer
        if (string_rating.isEmpty()){
            presenter.prepareInvalidRatingView("You did not input a rating. Please try again.");
            return;
        }

        // Check if the answer they input is a Double - if it is, save it
        double rating = 0.0;
        try {
            rating = Double.parseDouble(string_rating);
        } catch (NumberFormatException e){
            presenter.prepareInvalidRatingView("Please enter your score as a double (e.g. 1.0");
            return;
        }

        // Check the rating is valid
        if (rating < 1 || rating > 10) {
            presenter.prepareInvalidRatingView("The rating you inputted falls outside the range of []");
            return;
        }

        // We have already validated the date and checked if the date was one they wanted to modify
        // We have also validated that it is a valid rating that they have added.
        // Now all we have to do is call prepareSuccessView and add the data to the productivity data access interface
        this.dataAccessInterface.updateProductivity(username, date, (Double) rating);
        presenter.prepareSuccessView(new AddProductivityOutputData(rating, date, username));
    }
}