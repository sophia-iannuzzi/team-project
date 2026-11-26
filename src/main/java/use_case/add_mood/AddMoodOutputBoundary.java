package use_case.add_mood;
import java.time.LocalDate;

/**
 * The Output Boundary for the Add Mood Use case
 */
public interface AddMoodOutputBoundary {
    /**
     * Prepare a success view. This will present them with a message saying:
     * "You are now adding your mood for [date]" and then take them to the add mood screen.
     */
    public void prepareInvalidDateView(String errorMessage);

    public void prepareExistingMoodView(String errorMessage);

    public void prepareAddMoodView(LocalDate date, String username);

    public void prepareSuccessView(AddMoodOutputData moodOutputData);

}
