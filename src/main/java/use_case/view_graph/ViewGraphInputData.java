package use_case.view_graph;

/**
 * InputData holding information required by the ViewGraph use case
 */
public class ViewGraphInputData {
    private String username;
    private String typeSelected;

    public ViewGraphInputData(String username, String typeSelected) {
        this.username = username;
        this.typeSelected = typeSelected;
    }

    /**
     * @return username of current user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * @return type of graph selected by user to view
     */
    public String getTypeSelected() {
        return this.typeSelected;
    }
}
