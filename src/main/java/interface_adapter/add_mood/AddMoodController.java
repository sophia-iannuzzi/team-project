package interface_adapter.add_mood;
import use_case.add_mood.*;
import java.time.LocalDate;

public class AddMoodController {
    private final AddMoodDateInputBoundary dateInteractor;
    private final AddMoodInputBoundary moodInteractor;

    public AddMoodController(AddMoodDateInputBoundary dateInteractor, AddMoodInputBoundary moodInteractor){
        this.dateInteractor = dateInteractor;
        this.moodInteractor = moodInteractor;
    }

    // execute the code for the date object
    public void execute(String username, String date) {
        AddMoodDateInputData dateInputData = new AddMoodDateInputData(username, date);
        dateInteractor.execute(dateInputData);
    }

    public void execute(String username, LocalDate date, String mood){
        AddMoodInputData inputData = new AddMoodInputData(username, date, mood);
        moodInteractor.execute(inputData);
    }
}
