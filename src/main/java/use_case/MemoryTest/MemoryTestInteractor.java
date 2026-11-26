package use_case.MemoryTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Memory Test Interactor.
 */

public class MemoryTestInteractor implements MemoryTestInputBoundary {

    private final MemoryTestOutputBoundary memoryTestPresenter;
    private final MemoryTestDataAccessInterface userDataAccessObject;
    private final CognitiveTestDataAccessInterface cognitiveTestDataAccessInterface;

    private String username;
    private List<String> selectedWords;
    private final List<String> correctAnswers;
    private final List<String> submittedAnswers;
    private boolean testFinished = false;

    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();

    private ScheduledFuture<?> countdownTask;

    public MemoryTestInteractor(MemoryTestOutputBoundary memoryTestPresenter,
                                MemoryTestDataAccessInterface userDataAccessObject,
                                CognitiveTestDataAccessInterface cognitiveTestDataAccessInterface) {
        this.memoryTestPresenter = memoryTestPresenter;
        this.userDataAccessObject = userDataAccessObject;
        this.cognitiveTestDataAccessInterface = cognitiveTestDataAccessInterface;
        this.selectedWords = new ArrayList<>(); // words selected i.e. the correct words overall
        this.correctAnswers = new ArrayList<>(); // among the answers of the user which ones they got correct
        this.submittedAnswers = new ArrayList<>(); // all submitted
    }

    /**
     * Starts the memory test.
     */
    @Override
    public void userStartsMemorizationTest(MemoryTestInputData CognitiveDataInput)
    {
        // Get the username of the logged-in user
        this.username = CognitiveDataInput.getUsername();

        // Reset the test in case
        this.correctAnswers.clear();
        this.submittedAnswers.clear();
        this.testFinished = false;

        // Retrieve 8 random words from the JSON file
        this.selectedWords = userDataAccessObject.getRandomWords(8);

        // Tell the presenter to display the memorization screen
        memoryTestPresenter.prepareMemorizationView(selectedWords);
        // Initialize countdown
        memoryTestPresenter.updateTimer(8);

        // Start countdown asynchronously
        countdownTask = scheduler.scheduleAtFixedRate(new Runnable() {
            private int remainingSeconds = 8;

            @Override
            public void run() {
                remainingSeconds--;

                if (remainingSeconds > 0) {
                    memoryTestPresenter.updateTimer(remainingSeconds);
                } else {
                    countdownTask.cancel(false);
                    memoryTestPresenter.prepareAnsweringView();
                }
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    /**
     * Checks an answer submitted by the user.
     */
    @Override
    public void userSubmitsAnswers(String answer)
    {

        if (testFinished || answer == null || answer.trim().isEmpty()) {
            return;
        }

        String submittedAnswer = answer.trim();

        // Prevent duplicate submissions
        if (containsSubmittedAnswer(submittedAnswer)) {
            return;
        }

        // Store every submitted answer
        submittedAnswers.add(submittedAnswer);

        // Check whether the submitted word is one of the selected words
        checkAnswer(submittedAnswer);

        // Update the score displayed by the presenter
        memoryTestPresenter.updateSubmittedAnswers(submittedAnswers);
    }

    /**
     * Checks whether the user has already submitted this word.
     */
    private boolean containsSubmittedAnswer(String answer) {

        for (String submitted : submittedAnswers) {

            if (submitted.equalsIgnoreCase(answer)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Check if answer is correct or not.
     */
    private void checkAnswer(String answer) {

        for (String correctAnswer : selectedWords) {

            if (correctAnswer.equalsIgnoreCase(answer)) {
                correctAnswers.add(correctAnswer);
            }
        }
    }

    /**
     * Ends the memory test and displays the final score.
     */
    @Override
    public void userFinishesTest()
    {
        if (testFinished || selectedWords.isEmpty()) {
            return;
        }

        testFinished = true;

        int score = correctAnswers.size();
        int totalWords = selectedWords.size();

        List<String> missedWords = new ArrayList<>();

        // Add the rest of the correct words in list to show users what they missed
        for (String word : selectedWords) {

            if (!correctAnswers.contains(word)) {
                missedWords.add(word);
            }
        }

        // Save score in database
        cognitiveTestDataAccessInterface.saveUserAttemptTest(username, true, "Memory", score);

        // Send output data i.e. results for users to see
        MemoryTestOutputData outputData = new MemoryTestOutputData(
                username,
                score,
                totalWords,
                correctAnswers,
                missedWords
        );
        memoryTestPresenter.prepareResultsView(outputData);
    }
}
