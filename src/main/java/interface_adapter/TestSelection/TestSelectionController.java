package interface_adapter.TestSelection;

import use_case.TestSelection.TestSelectionInputBoundary;
import use_case.TestSelection.TestSelectionInputData;

/**
 * The controller for the Test Selection Use Case.
 */
public class TestSelectionController {
    private final TestSelectionInputBoundary ChooseCognitiveTestInteractor;

    public TestSelectionController(TestSelectionInputBoundary ChooseCognitiveTestInteractor)
    {
        this.ChooseCognitiveTestInteractor = ChooseCognitiveTestInteractor;
    }

    /**
     * Executes the Test Selection Use Case.
     * @param username the username of the user who is logged in
     * @param hasDoneTest to determine if the user has already done a test for the day
     * @param testType to determine what Cognitive Test the user chooses to do
     */
    public void execute(String username, boolean hasDoneTest, String testType)
    {
        // creating input data
        final TestSelectionInputData inputData = new TestSelectionInputData(username, hasDoneTest, testType);
        // depending on the testType execute that use case and send input data
        ChooseCognitiveTestInteractor.execute(inputData);
        ;

    }
}
