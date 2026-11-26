package interface_adapter.MemoryTest;

import use_case.MemoryTest.MemoryTestInputBoundary;
import use_case.MemoryTest.MemoryTestInputData;

/**
 * The controller for the Memory Test Use Case.
 */

public class MemoryTestController {
    private final MemoryTestInputBoundary memoryTestInteractor;

    public MemoryTestController(MemoryTestInputBoundary memoryTestInteractor)
    {
        this.memoryTestInteractor = memoryTestInteractor;
    }

    /**
     * Executes the Memory Test Use Case; starts with allowing memorization.
     * @param username the username of the user who is logged in
     */
    public void userStartsMemorizationTest(String username)
    {
        // creating input data
        final MemoryTestInputData inputData = new MemoryTestInputData(username);
        // execute the test now
        memoryTestInteractor.userStartsMemorizationTest(inputData);
    }

    /**
     * Executes the Test Selection Use Case.
     * @param answer the input of the user
     */
    public void userSubmitsAnswers(String answer) {
        memoryTestInteractor.userSubmitsAnswers(answer);
    }

    /**
     * Executes the final stage of the use case; the results.
     */
    public void userFinishesTest() {
        memoryTestInteractor.userFinishesTest();
    }
}
