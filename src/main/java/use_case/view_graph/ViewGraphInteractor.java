package use_case.view_graph;

/**
 * The ViewGraph use case interactor
 */
public class ViewGraphInteractor implements ViewGraphInputBoundry {
//    private ViewGraphDataAccessInterface dBAccess;
    private ViewGraphOutputBoundry presenter;

    /**
     * Executes the ViewGraph use case.
     * @param inputData the required information for the use case
     */
    @Override
    public void execute(ViewGraphInputData inputData) {
        // use case
        // search for data in database
        // take return of database (list of cognitive data) and send to presenter
    }
}
