package interface_adapter.add_mood;

import ViewManager.ViewManager;
import ViewManager.ViewManagerModel;
import use_case.add_mood.*;

import java.time.LocalDate;

public class AddMoodPresenter implements AddMoodOutputBoundary {
    private final MoodInputViewModel viewModel;
    private final ViewManagerModel viewManagerModel;

    /**
     * Make a constructor that takes in @param viewModel and @param viewManagerModel to manage the views that the
     * add productivity works with.
     */
    public AddMoodPresenter(MoodInputViewModel viewModel, ViewManagerModel viewManagerModel){
        this.viewModel = viewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareInvalidDateView(String error_message){
        // I need to get the current state of the model
        AddMoodState moodState = viewModel.getState();

        moodState.setInvalidViewError(error_message);


    }

    @Override
    public void prepareExistingMoodView(String errorMessage){

    }

    @Override
    public void prepareAddMoodView(LocalDate date, String username){

    }

    @Override
    public void prepareSuccessView(AddMoodOutputData moodOutputData){

    }
}
