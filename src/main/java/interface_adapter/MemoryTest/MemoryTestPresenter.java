package interface_adapter.MemoryTest;

import ForTestingCognitiveTests.ViewManager.CognitiveTestViewManagerModel;
import use_case.MemoryTest.MemoryTestOutputBoundary;
import use_case.MemoryTest.MemoryTestOutputData;

import java.util.List;

/**
 * The Presenter for the Memory Test Use Case.
 */

public class MemoryTestPresenter implements MemoryTestOutputBoundary {

    private final MemoryTestViewModel memoryTestViewModel;
    private final CognitiveTestViewManagerModel viewManagerModel;

    public MemoryTestPresenter(MemoryTestViewModel memoryTestViewModel, CognitiveTestViewManagerModel viewManagerModel) {
        this.memoryTestViewModel = memoryTestViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareMemorizationView(List<String> words) {
        MemoryTestState state = memoryTestViewModel.getState();

        state.setSelectedWords(words);
        state.setGameState(MemoryTestGameState.MEMORIZATION);
        state.setScore(0);
        state.setTotalWords(words.size());

        memoryTestViewModel.setState(state);

        // Switch to the Memory Test screen
        viewManagerModel.setState(MemoryTestViews.MEMORIZATION);
        viewManagerModel.notifyViewChanged();
    }

    @Override
    public void updateTimer(int seconds) {
        MemoryTestState state = memoryTestViewModel.getState();
        state.setRemainingSeconds(seconds);
        memoryTestViewModel.setState(state);
    }

    @Override
    public void prepareAnsweringView() {
        MemoryTestState state = memoryTestViewModel.getState();
        state.setGameState(MemoryTestGameState.ANSWER);

        memoryTestViewModel.setState(state);

        viewManagerModel.setState(MemoryTestViews.ANSWERING);
        viewManagerModel.notifyViewChanged();
    }

    @Override
    public void updateSubmittedAnswers(List<String> submittedAnswers) {

        MemoryTestState state = memoryTestViewModel.getState();

        state.setSubmittedAnswers(submittedAnswers);

        memoryTestViewModel.setState(state);
    }

    @Override
    public void prepareResultsView(MemoryTestOutputData outputData) {
        MemoryTestState state = memoryTestViewModel.getState();

        state.setUsername(outputData.getUsername());
        state.setScore(outputData.getScore());
        state.setTotalWords(outputData.getTotalWords());
        state.setCorrectWords(outputData.getCorrectWords());
        state.setMissedWords(outputData.getMissedWords());

        memoryTestViewModel.setState(state);

        viewManagerModel.setState(MemoryTestViews.RESULTS);
        viewManagerModel.notifyViewChanged();
    }
}
