package use_case.add_productivity;

import java.time.LocalDate;

public interface AddProductivityOutputBoundary {

    public void prepareInvalidDateView(String error_message);   // They have entered an invalid date

    public void prepareExistingProductivityView(String error_message);  //They have chosen a date that already has a rating

    public void prepareAddProductivityView(LocalDate date, String username);    // They have given a correct date and can now add their productivity rating

    public void prepareSuccessView(AddProductivityOutputData addProductivityOutputData);    // They have successfully logged their productivity rating

    public void prepareInvalidRatingView(String error_message);
}
