package use_case.add_mood;
import entities.CognitiveData;
import use_case.data_access.MoodDataAccessInterface;
import java.util.*;
import java.time.LocalDate;

/**
 * The Add Mood Interactor
 */
public class AddMoodInteractor implements AddMoodDateInputBoundary, AddMoodInputBoundary{
    private final MoodDataAccessInterface moodDataAccessInterface;
    private final AddMoodOutputBoundary presenter;

    /**
     * The class constructor
     */
    public AddMoodInteractor(MoodDataAccessInterface moodDataAccessInterface, AddMoodOutputBoundary addMoodOutputBoundary) {
        this.moodDataAccessInterface = moodDataAccessInterface;
        this.presenter = addMoodOutputBoundary;
    }

    @Override
    public void execute(AddMoodDateInputData addMoodDateInputData){
        //Get the input data from our InputData object
        final String username = addMoodDateInputData.getUsername();
        final String string_date = addMoodDateInputData.getDate();

        // Check that the date actually exists
        String[] date_break_down = string_date.split("/");

        // If the date does not follow the structure of a date in any way, ask them to retry
        if (date_break_down.length != 3) {
            presenter.prepareInvalidDateView("The date you entered is invalid. Please try again!");
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

            //Check that the year is valid (Because the program is being used in 2026, we aren't going to have them add data that is from several years ago
            if (date_break_down_ints[2] < 2026 || LocalDate.now().getYear() < date_break_down_ints[2]) {
                // This means that the date they are adding their mood for a year before the program was created, or they are adding their mood for a time that is in the future (we don't want them to add future moods)
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

                // The date is correctly formatted - now we can check if there is a current mood entry for this date in
                // the cognitive data access object
                CognitiveData[] cogData = this.moodDataAccessInterface.getCognitiveData(username);

                // Check if there are any entries for the date for that user
                for (CognitiveData cognitiveData: cogData){
                    if (cognitiveData.getDate() == date) {
                        // Check if the cognitive data already has a mood input
                        if (cognitiveData.getMood() != "none"){
                            // This means that the date has already been added
                            presenter.prepareExistingMoodView("You already have added a mood for " + date.toString() +
                                    ". Would you like to edit this date? (please answer with 'y' to continue " +
                                    "modifying, or 'n' to return to the home screen)");
                            return;
                        }
                    }
                }

                // If we have reached this part of the code, then the date is correctly formatted and there is not an existing
                // mood value for the date, so we can continue to AddMood
                presenter.prepareAddMoodView(date);

            }
        }

    }

    @Override
    public void execute(AddMoodInputData moodDateInputData){

    }




}
