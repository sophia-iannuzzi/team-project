package interface_adapter.TestSelection;

import usecase.TestSelection.TestSelectionInputBoundary;
import usecase.TestSelection.TestSelectionInputData;

/**
 * A controller class representing
 */
public class TestSelectionController {
    private final TestSelectionInputBoundary ChooseCognitiveTestInteractor;

    public TestSelectionController(TestSelectionInputBoundary ChooseCognitiveTestInteractor)
    {
        this.ChooseCognitiveTestInteractor = ChooseCognitiveTestInteractor;
    }

    public void execute(String username, boolean hasDoneTest, String testType)
    {
        // creating input data
        final TestSelectionInputData inputData = new TestSelectionInputData(username, hasDoneTest, testType);
        // depending on the testType execute that use case and send input data
        ChooseCognitiveTestInteractor.execute(inputData);
        ;

    }
}
