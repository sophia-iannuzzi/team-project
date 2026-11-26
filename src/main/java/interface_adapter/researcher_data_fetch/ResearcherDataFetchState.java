package interface_adapter.researcher_data_fetch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResearcherDataFetchState {
    private List<CognitiveDataTable> table;
    private Date start;
    private Date finish;
    private String error;
    private String testType;

    public List<CognitiveDataTable> getTable() {
        return table;
    }

    public void setTable(List<CognitiveDataTable> table) {
        this.table = table;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(Date finish) {
        this.finish = finish;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
}
