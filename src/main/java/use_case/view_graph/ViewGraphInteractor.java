package use_case.view_graph;
import entities.CognitiveData;

import java.util.*;

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
     *
     * @param inputData the required information for the use case
     */
    @Override
    public void execute(ViewGraphInputData inputData) {
        // use case
        // search for data in database
        // take return of database (list of cognitive data) and send to presenter as outputdata

        // get an array of CognitiveData from the storage for the current user
        CognitiveData[] cognitiveData = this.dataBaseAccess.getData(inputData.getUsername());
        String choice = inputData.getTypeSelected();

        // set the x and y axis titles
        String xName = inputData.getTypeSelected();
        String yName = "Productivity";

        if (choice.equals("mood")) {

            ArrayList<String> xValues = new ArrayList<String>();
            // accumulate the moods on the x-axis
            for (CognitiveData data : cognitiveData) {
                // add one of each mood
                if (!xValues.contains(data.getMood())) {
                    xValues.add(data.getMood());
                }
            }

            double[] yValues = new double[xValues.size()];
            // accumulate the corresponding productivity values per mood on the y-axis
            int i = 0;
            for (String mood : xValues) {
                yValues[i] = this.getAverageMood(mood, cognitiveData);
                i++;
            }

            // create the output data
            ViewGraphOutputData outputData = new ViewGraphOutputData(xName, yName, xValues.toArray(), yValues);

            // pass output data to presenter
            this.presenter.prepareSuccessView(outputData);
        }
    }

    /**
     * Helper function to execute. Gets the average productivity rating of current user for a mood.
     * @param mood the mood.
     * @param cognitiveData array of all this user's CognitiveData
     * @return the average productivity rating of the mood.
     */
    private double getAverageMood(String mood, CognitiveData[] cognitiveData) {
        int amountForMood = 0;
        double sum = 0;
        for (CognitiveData data : cognitiveData) {
            if (data.getMood().equals(mood)) {
                amountForMood++;
                sum += data.getProductivity();
            }
        }

        if (amountForMood > 0) {
            return sum / amountForMood;
        }

        return 0;
    }
}
