package use_case.view_graph;

/**
 * OutputBoundry for the ViewGraph use case.
 */
public interface ViewGraphOutputBoundry {
    /**
     * Prepare to show the chosen graph.
     * @param viewGraphOutputData the information required to make the graph.
     */
    void prepareSuccessView(ViewGraphOutputData viewGraphOutputData);

    void prepareReturnView();
}
