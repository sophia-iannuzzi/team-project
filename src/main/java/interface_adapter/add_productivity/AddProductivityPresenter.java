package interface_adapter.add_productivity;

import interface_adapter.Loggedin.LoggedinState;
import use_case.add_productivity.*;
import view.add_productivity_views.ProductivityInputView;

import java.time.LocalDate;

/**
 * Implementations of my ProductivityOutputBoundary classes.
 * This class should be prepping my view model.
 */
public class AddProductivityPresenter implements AddProductivityOutputBoundary {
    private final ProductivityInputViewModel viewModel;

    public AddProductivityPresenter(ProductivityInputViewModel viewModel){
        this.viewModel = viewModel;
    }

    /**
     * Takes in @param error_message, which will be displayed to the user on the date input screen (below the prompt
     * asking for the date value). This message will remain in place until they enter a correct date. This should call
     * the interactor with the new date that they enter if they enter an updated date.
     */
    public void prepareInvalidDateView(String error_message) {
        AddProductivityState state = this.viewModel.getState();
        state.setError(error_message);
        viewModel.notifyStateChanged();
    }

    /**
     * Takes in @param error_message, which will be displayed to the user on the date input screen (below the prompt
     * asking for the date value). This message should pop up as a new screen for the user, then should return them to the
     * home screen.
     */
    public void prepareExistingProductivityView(String error_message) {
        AddProductivityState state = this.viewModel.getState();
        state.setError(error_message);
        viewModel.notifyStateChanged();
    }

    /**
     * Takes in @param AddProductivity, which will be displayed to the user on the date input screen (below the prompt
     * asking for the date value). This message will remain in place until they enter a correct date. This should call
     * the interactor with the new date that they enter if they enter an updated date.
     */
    public void prepareSuccessView(AddProductivityOutputData addProductivityOutputData){
        final AddProductivityState state = this.viewModel.getState();
        LocalDate date = addProductivityOutputData.getDate();
        Double rating = addProductivityOutputData.getRating();
        String username = addProductivityOutputData.getUsername();
        state.setDate(date);
        state.setRating(rating);
        state.setMessage("You have successfully logged a productivity rating of " + rating.toString() +
                " for " + date.toString());
        state.setError("");
        state.setUsername(username);
        viewModel.notifyStateChanged();
    }

    /**
     * Takes in @param error_message, which will be displayed to the user on the rating input screen (below the prompt
     * asking for the rating value). This message will remain in place until they enter a double that is between [1.0,
     * 10.0] inclusive. There are different messages depending on what type of error they make.
     */
    public void prepareInvalidRatingView(String error_message){
        AddProductivityState state = this.viewModel.getState();
        state.setError(error_message);
        viewModel.notifyStateChanged();
    }

}
