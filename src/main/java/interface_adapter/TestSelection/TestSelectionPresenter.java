package interface_adapter.TestSelection;
import ForTestingCognitiveTests.ViewManager.CognitiveTestViewManagerModel;
import interface_adapter.AttentionTest.AttentionTestState;
import interface_adapter.AttentionTest.AttentionTestViewModel;
import interface_adapter.MemoryTest.MemoryTestState;
import interface_adapter.MemoryTest.MemoryTestViews;
import use_case.TestSelection.TestSelectionOutputBoundary;
import use_case.TestSelection.TestSelectionOutputData;
import interface_adapter.MemoryTest.MemoryTestViewModel;

import java.util.Objects;

/**
 * The Presenter for the Test Selection Use Case.
 */

public class TestSelectionPresenter implements TestSelectionOutputBoundary {

    private final TestSelectionViewModel testSelectionViewModel;
    private final CognitiveTestViewManagerModel viewManagerModel;

    private final MemoryTestViewModel memoryTestViewModel;
    private final AttentionTestViewModel attentionTestViewModel;

    public TestSelectionPresenter(CognitiveTestViewManagerModel viewManagerModel,
                                  TestSelectionViewModel testSelectionViewModel,
                                  MemoryTestViewModel memoryTestViewModel,
                                  AttentionTestViewModel attentionTestViewModel)
    {
        this.viewManagerModel = viewManagerModel;
        this.testSelectionViewModel = testSelectionViewModel;
        this.memoryTestViewModel = memoryTestViewModel;
        this.attentionTestViewModel = attentionTestViewModel;
    }

    @Override
    public void prepareSuccessView(TestSelectionOutputData outputData)
    {
        // update to new state and notify

        System.out.println(outputData.getUsername());

        if (Objects.equals(outputData.getTestTypeUserSelected(), "MEMORY"))
        {

            // On success, update the testSelectionViewModel's state
            final MemoryTestState memoryTestState = memoryTestViewModel.getState();

            // send user's username
            memoryTestState.setUsername(outputData.getUsername());

            this.memoryTestViewModel.setState(memoryTestState);
            this.memoryTestViewModel.notifyStateChanged();

            // and clear everything from the testSelectionViewModel's state
            this.testSelectionViewModel.setState(new TestSelectionState());
            this.testSelectionViewModel.notifyStateChanged();

            // switch to the MemoryTestViewModel in view
            this.viewManagerModel.setState(MemoryTestViews.MEMORIZATION);
            this.viewManagerModel.notifyViewChanged();
        }
        else if (Objects.equals(outputData.getTestTypeUserSelected(), "ATTENTION"))
        {
            final AttentionTestState attentionTestState = attentionTestViewModel.getState();
            attentionTestState.setUsername(outputData.getUsername());
            this.attentionTestViewModel.notifyStateChanged();

            // and clear everything from the testSelectionViewModel's state
            this.testSelectionViewModel.setState(new TestSelectionState());
            this.testSelectionViewModel.notifyStateChanged();

            // switch to the AttentionTestViewModel in view
            this.viewManagerModel.setState(AttentionTestViewModel.VIEW_NAME);
            this.viewManagerModel.notifyViewChanged();
        }

    }

    @Override
    public void prepareFailView(String errorMessage)
    {
        final TestSelectionState testSelectionState = testSelectionViewModel.getState();
        testSelectionState.setTestError(errorMessage);
        testSelectionViewModel.notifyStateChanged();
    }
}
