package use_case.view_graph;
import entities.CognitiveData;

import java.util.Date;

/**
 * The ViewGraph use case interactor
 */
public class ViewGraphInteractor implements ViewGraphInputBoundry {
    private ViewGraphDataAccessInterface dataBaseAccess;
    private ViewGraphOutputBoundry presenter;

    ViewGraphInteractor(ViewGraphDataAccessInterface dBAccess, ViewGraphOutputBoundry presenter) {
        this.dataBaseAccess = dBAccess;
        this.presenter = presenter;
    }

    /**
     * Executes the ViewGraph use case.
     * @param inputData the required information for the use case
     */
    @Override
    public void execute(ViewGraphInputData inputData) {
        // use case
        // search for data in database
        // take return of database (list of cognitive data) and send to presenter as outputdata

        // get an array of CognitiveData from the storage for the current user
        CognitiveData[] cognitiveData = this.dataBaseAccess.getData(inputData.getUsername());

        // set the x and y axis titles
        String xName = inputData.getTypeSelected();
        String yName = "Productivity";

        // accumulate the data points for the x and y values
        int i = 0;
        for (CognitiveData data : cognitiveData) {
            Date date = data.getDate();

            double[] yValues = new double[1];
            yValues[i] = data.getProducitivty();
            Object[] xValues;

            i++;
        }

    }
}
