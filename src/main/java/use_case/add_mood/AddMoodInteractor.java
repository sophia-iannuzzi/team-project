package use_case.add_mood;
import data_access.MoodDataAccessObject;
import entities.RegularUser;
import entities.CognitiveData;
import use_case.data_access.MoodDataAccessInterface;

public class AddMoodInteractor implements AddMoodInputBoundary{
    private final MoodDataAccessInterface moodDataAccessInterface;
    private final AddMoodOutputBoundary presenter;
    private final MoodDataAccessObject moodDataAccessObject;

    public AddMoodInteractor(MoodDataAccessInterface moodDataAccessInterface, AddMoodOutputBoundary addMoodOutputBoundary,
                             MoodDataAccessObject moodDataAccessObject){
        this.moodDataAccessInterface = moodDataAccessInterface;
        this.presenter = addMoodOutputBoundary;
        this.moodDataAccessObject = moodDataAccessObject;
    }



}
