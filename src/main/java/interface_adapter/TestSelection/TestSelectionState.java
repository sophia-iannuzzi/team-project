package interface_adapter.TestSelection;

public class TestSelectionState {

    private String username = "";
    private boolean hasDoneTest = false;
    private String testType = "";
    private String testError;

    public boolean getTestDone() {
        return hasDoneTest;
    }

    public void setTestDone(boolean hasDoneTest) {
        this.hasDoneTest = hasDoneTest;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTestError() {
        return testError;
    }

    public void setTestError(String testError) {
        this.testError = testError;
    }

    public String getTestType() {
        return testType;
    }

    public void setTestType(String testType) {
        this.testType = testType;
    }
}
