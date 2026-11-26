package use_case.TestSelection;

/**
 * The Test Selection Interactor.
 */

public class TestSelectionInteractor implements TestSelectionInputBoundary {

    private final TestSelectionOutputBoundary testSelectionPresenter;
    private final TestSelectionDataAccessInterface userDataAccessObject;

    public TestSelectionInteractor(TestSelectionDataAccessInterface testSelectionDataAccessInterface,
                                   TestSelectionOutputBoundary testSelectionPresenter) {
        this.userDataAccessObject = testSelectionDataAccessInterface;
        this.testSelectionPresenter = testSelectionPresenter;
    }

    @Override
    public void execute(TestSelectionInputData CognitiveDataInput) {

        final String username = CognitiveDataInput.getUsername();
        final boolean doneTest = CognitiveDataInput.getUserHasDoneTest();

        if (doneTest)
        {
            this.testSelectionPresenter.prepareFailView("You have already done a test today");
        }
        else
        {
            // make sure database is notified that this user has done a test for the day now
            // and score is 0 for now
            this.userDataAccessObject.saveUserAttemptTest(username, true,
                    CognitiveDataInput.getTestType(), 0.0);

            final TestSelectionOutputData loginOutputData = new TestSelectionOutputData(username,
                    CognitiveDataInput.getTestType());

            this.testSelectionPresenter.prepareSuccessView(loginOutputData);
        }
    }
}
