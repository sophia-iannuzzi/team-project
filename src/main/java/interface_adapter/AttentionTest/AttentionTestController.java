package interface_adapter.AttentionTest;

import use_case.AttentionTest.AttentionTestInputBoundary;
import use_case.AttentionTest.AttentionTestInputData;
import use_case.AttentionTest.AttentionTestInteractor;

/**
 * The controller for the Attention Test Use Case.
 */

public class AttentionTestController {

    private final AttentionTestInputBoundary attentionTestInteractor;

    public AttentionTestController(AttentionTestInputBoundary attentionTestInteractor)
    {
        this.attentionTestInteractor = attentionTestInteractor;
    }

    /**
     * Executes the Test Selection Use Case.
     * @param username the username of the user who is logged in
     */
    public void execute(String username)
    {
        // creating input data
        final AttentionTestInputData inputData = new AttentionTestInputData(username);
        // execute the test now
        AttentionTestInteractor.execute(inputData);
    }
}
