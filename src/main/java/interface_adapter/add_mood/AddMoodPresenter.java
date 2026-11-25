package interface_adapter.add_mood;

import use_case.add_mood.*;

import java.time.LocalDate;

public class AddMoodPresenter implements AddMoodOutputBoundary {

    public void prepareInvalidDateView(String errorMessage);

    public void prepareExistingMoodView(String errorMessage);

    public void prepareAddMoodView(LocalDate date);

    public void prepareSuccessView(AddMoodOutputData moodOutputData);
}
