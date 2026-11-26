package interface_adapter.researcher_data_fetch;

import java.util.Date;

public class CognitiveDataTable {
    private final Date date;
    private final Double productivity;
    private final Double score;
    private final String mood;
    private final String testType;

    public CognitiveDataTable(Date date, Double productivity, Double score, String mood, String testType){
        this.date = date;
        this.productivity = productivity;
        this.score = score;
        this.mood = mood;
        this.testType = testType;
    }


    public Date getDate() {
        return date;
    }

    public Double getProductivity() {
        return productivity;
    }

    public Double getScore() {
        return score;
    }

    public String getMood() {
        return mood;
    }

    public String getTestType() {
        return testType;
    }
}
