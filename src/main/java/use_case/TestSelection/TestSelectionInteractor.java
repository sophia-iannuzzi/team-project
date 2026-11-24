package use_case.TestSelection;

import entities.RegularUser;

public class TestSelectionInteractor implements TestSelectionInputBoundary {

    private final TestSelectionOutputBoundary testSelectionPresenter;
    private final TestSelectionDataAccessInterface userDataAccessObject;

    public TestSelectionInteractor(TestSelectionDataAccessInterface testSelectionDataAccessInterface,
                                   TestSelectionOutputBoundary testSelectionPresenter) {
        this.testSelectionPresenter = testSelectionPresenter;
        this.userDataAccessObject = testSelectionDataAccessInterface;
    }

    @Override
    public void execute(TestSelectionInputData CognitiveDataInput) {

        final String username = CognitiveDataInput.getUsername();
        final boolean doneTest = CognitiveDataInput.getUserHasDoneTest();

        if (doneTest)
        {
            testSelectionPresenter.prepareFailView("You have already done a test today");
        }
        else
        {

            // if regular user has not done a test today, get this user
            final RegularUser user = userDataAccessObject.get(CognitiveDataInput.getUsername());

            // make sure database is notified that this user has done a test for the day now
            userDataAccessObject.saveUserAttemptTest(username, true, CognitiveDataInput.getTestType());

            final TestSelectionOutputData loginOutputData = new TestSelectionOutputData(username,
                    CognitiveDataInput.getTestType());
            testSelectionPresenter.prepareSuccessView(loginOutputData);
        }
    }
}
