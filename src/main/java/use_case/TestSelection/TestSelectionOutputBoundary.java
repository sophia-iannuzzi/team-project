package use_case.TestSelection;

public interface TestSelectionOutputBoundary {

    /**
     * Prepares the success view for Choosing Cognitive Test Use Case
     * @param outputData the output data
     */
    void prepareSuccessView(TestSelectionOutputData outputData);

    /**
     * Prepares the failure view for the Choosing Cognitive Test Use Case
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
