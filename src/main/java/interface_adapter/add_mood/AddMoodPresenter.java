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
        moodState.setError(error_message);
        this.viewModel.notifyStateChanged();
    }

    @Override
    public void prepareExistingMoodView(String error_message){
        AddMoodState moodState = viewModel.getState();
        moodState.setError(error_message);
        this.viewModel.notifyStateChanged();

    }

    @Override
    public void prepareAddMoodView(LocalDate date, String username){
        AddMoodState moodState = viewModel.getState();
        //TODO: Need to figure this one out

    }

    @Override
    public void prepareSuccessView(AddMoodOutputData moodOutputData){
        AddMoodState moodState = viewModel.getState();
        LocalDate date = moodOutputData.getDate();
        String mood = moodOutputData.getMood();
        String username = moodOutputData.getUsername();
        moodState.setError("");
        moodState.setDate(date);
        moodState.setMood(mood);
        moodState.setUsername(username);
        moodState.setMessage("You have successfully added " + mood + " as your overall mood on " + date.toString());

        this.viewModel.notifyStateChanged();
    }
}
