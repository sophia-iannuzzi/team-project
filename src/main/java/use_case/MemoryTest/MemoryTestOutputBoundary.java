package use_case.MemoryTest;

import java.util.List;

/**
 * Output Boundary for the Memory Use Case.
 */

public interface MemoryTestOutputBoundary {

    /**
     * Starts the memory test.
     */
    void prepareMemorizationView(List<String> words);

    /**
     * Updates the memorization timer during the memory test.
     */
    void updateTimer(int seconds);

    /**
     * The state in which users input the answers where they memorized, here we will check answers.
     */
    void prepareAnsweringView();

    /**
     * Update view so user can see what answers they input.
     */
    void updateSubmittedAnswers(List<String> submittedAnswers);

    /**
     * User sees their final result.
     */
    void prepareResultsView(MemoryTestOutputData outputData);
}
