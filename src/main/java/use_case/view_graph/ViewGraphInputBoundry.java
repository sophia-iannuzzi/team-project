package use_case.view_graph;

/**
 * InputBoundry for actions involving a user viewing a graph
 */
public interface ViewGraphInputBoundry {
    /**
     * Executes the ViewGraph use case
     * @param inputData the required information for the use case
     */
    public void execute(ViewGraphInputData inputData);
}
