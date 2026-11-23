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
//        Date[] dataDates = cognitiveData[0].Keys();

        String xName;
        String yName;


        for (CognitiveData data : cognitiveData) {


            Double[] yValues;
            Object[] xValues;
        }

    }
}
