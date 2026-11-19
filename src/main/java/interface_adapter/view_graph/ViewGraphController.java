package interface_adapter.view_graph;

import use_case.view_graph.ViewGraphInputBoundry;
import use_case.view_graph.ViewGraphInputData;

/**
 * The Controller for the ViewGraph use case
 */
public class ViewGraphController {
    private final ViewGraphInputBoundry useCaseInteractor;

    public ViewGraphController(ViewGraphInputBoundry useCaseInteractor) {
        this.useCaseInteractor = useCaseInteractor;
    }

    /**
     * Executes the ViewGraph use case.
     * @param username the current user's username
     * @param typeSelected the type of graph selected by the user to view.
     */
    public void execute(String username, String typeSelected) {
        ViewGraphInputData inputData = new ViewGraphInputData(username, typeSelected);

        useCaseInteractor.execute(inputData);
    }
}
