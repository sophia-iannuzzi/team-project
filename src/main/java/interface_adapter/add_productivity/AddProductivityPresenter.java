package interface_adapter.add_productivity;

import use_case.add_productivity.*;

import java.time.LocalDate;

public class AddProductivityPresenter implements AddProductivityOutputBoundary {

    /**
     * Takes in @param error_message, which will be displayed to the user on the date input screen (below the prompt
     * asking for the date value). This message will remain in place until they enter a correct date. This should call
     * the interactor with the new date that they enter if they enter an updated date.
     */
    public void prepareInvalidDateView(String error_message) {

    }

    /**
     * Takes in @param error_message, which will be displayed to the user on the date input screen (below the prompt
     * asking for the date value). This message should pop up as a new screen for the user, then should return them to the
     * home screen.
     */
    public void prepareExistingProductivityView(String error_message) {

    }

    /**
     * Takes in @params date and username. These are taken in so that we can make a new InputData object with these
     * Then they should come to a new view that asks them to add their productivity rating. The mood that they input will be passed
     * through the controller to the inputData and the Interactor again.
     */

    public void prepareAddProductivityView(LocalDate date, String username) {


    }

    /**
     * Takes in @param AddProductivity, which will be displayed to the user on the date input screen (below the prompt
     * asking for the date value). This message will remain in place until they enter a correct date. This should call
     * the interactor with the new date that they enter if they enter an updated date.
     */
    public void prepareSuccessView(AddProductivityOutputData addProductivityOutputData){

    }

    /**
     * Takes in @param error_message, which will be displayed to the user on the rating input screen (below the prompt
     * asking for the rating value). This message will remain in place until they enter a double that is between [1.0,
     * 10.0] inclusive. There are different messages depending on what type of error they make.
     */
    public void prepareInvalidRatingView(String error_message){

    }

}
