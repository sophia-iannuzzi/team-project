package use_case.view_graph;
import entities.CognitiveData;

import java.util.*;

/**
 * The ViewGraph use case interactor
 */
public class ViewGraphInteractor implements ViewGraphInputBoundry {
    private final ViewGraphDataAccessInterface dataBaseAccess;
    private final ViewGraphOutputBoundry presenter;

    public ViewGraphInteractor(ViewGraphDataAccessInterface dBAccess, ViewGraphOutputBoundry presenter) {
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
        // get an array of CognitiveData from the storage for the current user
        CognitiveData[] cognitiveData = this.dataBaseAccess.getData(inputData.getUsername());
        String choice = inputData.getTypeSelected();

        // set the x and y axis titles
        String xName = inputData.getTypeSelected();
        String yName = "Productivity";

        // user selects mood scenario
        switch (choice) {
            case "mood":
                List<String> xBarValues = new ArrayList<String>();
                // accumulate the moods on the x-axis
                for (CognitiveData data : cognitiveData) {
                    // add one of each mood
                    if (!xBarValues.contains(data.getMood())) {
                        xBarValues.add(data.getMood());
                    }
                }

                List<Double> yBarValues = new ArrayList<Double>();
                // accumulate the corresponding productivity values per mood on the y-axis
                for (String mood : xBarValues) {
                    yBarValues.add((Double)this.getAverageProductivityMood(mood, cognitiveData));
                }

                // create the output data
                ViewGraphOutputData outputBarData = new ViewGraphOutputData("bar", "Mood", yName,
                        (List<Object>)(Object)xBarValues, yBarValues);

                // pass output data to presenter
                this.presenter.prepareSuccessView(outputBarData);

            case "score":
                List<Double> xLineValues = new ArrayList<Double>();
                // accumulate the scores on the x-axis
                for (CognitiveData data : cognitiveData) {
                    // add one of each score
                    Double score = (Double)data.getCognitiveTest()[1];
                    if (!xLineValues.contains(score)) {
                        xLineValues.add(score);
                    }
                }

                List<Double> yLineValues = new ArrayList<Double>();
                // accumulate the corresponding productivity values per score on the y-axis
                for (double score : xLineValues) {
                    yLineValues.add((Double)this.getAverageProductivityScore(score, cognitiveData));
                }

                // create the output data
                ViewGraphOutputData outputLineData = new ViewGraphOutputData("line", "Scores", yName,
                        (List<Object>)(Object)xLineValues, yLineValues);

                // pass output data to presenter
                this.presenter.prepareSuccessView(outputLineData);
        }
    }

    /**
     * Helper function to execute. Gets the average productivity rating of current user for a mood.
     * @param mood the mood.
     * @param cognitiveData array of all this user's CognitiveData
     * @return the average productivity rating of the mood.
     */
    private double getAverageProductivityMood(String mood, CognitiveData[] cognitiveData) {
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

    /**
     * Helper function to execute. Gets the average productivity rating of current user for a score.
     * @param score the score.
     * @param cognitiveData array of all this user's CognitiveData
     * @return the average productivity rating of the mood.
     */
    private double getAverageProductivityScore(double score, CognitiveData[] cognitiveData) {
        int amountForMood = 0;
        double sum = 0;
        for (CognitiveData data : cognitiveData) {
            if (data.getCognitiveTest()[1].equals(score)) {
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
