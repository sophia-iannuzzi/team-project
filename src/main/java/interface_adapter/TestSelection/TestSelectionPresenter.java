package interface_adapter.TestSelection;
import interface_adapter.AttentionTest.AttentionTestState;
import interface_adapter.AttentionTest.AttentionTestViewModel;
import interface_adapter.MemoryTest.MemoryTestState;
import use_case.TestSelection.TestSelectionOutputBoundary;
import use_case.TestSelection.TestSelectionOutputData;
import interface_adapter.MemoryTest.MemoryTestViewModel;
import ViewManager.ViewManagerModel;

public class TestSelectionPresenter implements TestSelectionOutputBoundary {

    private final TestSelectionViewModel testSelectionViewModel;
    private final ViewManagerModel viewManagerModel;

    private final MemoryTestViewModel memoryTestViewModel;
    private final AttentionTestViewModel attentionTestViewModel;

    public TestSelectionPresenter(ViewManagerModel viewManagerModel,
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

        if (outputData.getTestTypeUserSelected() == "MEMORY")
        {
            // On success, update the testSelectionViewModel's state
            final MemoryTestState memoryTestState = memoryTestViewModel.getState();
            memoryTestState.setUsername(outputData.getUsername());
            this.memoryTestViewModel.notifyStateChanged();

            // and clear everything from the testSelectionViewModel's state
            this.testSelectionViewModel.setState(new TestSelectionState());
            this.testSelectionViewModel.notifyStateChanged();

            // switch to the MemoryTestViewModel in view
            this.viewManagerModel.setState(MemoryTestViewModel.VIEW_NAME);
            this.viewManagerModel.notifyViewChanged();
        }
        else if (outputData.getTestTypeUserSelected() == "ATTENTION")
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
