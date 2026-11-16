package usecase.TestSelection;

public class TestSelectionOutputData {
    private final String testType;
    private final String username;

    public TestSelectionOutputData(String testType, String username)
    {
        this.testType = testType;
        this.username = username;
    }

    public String getTestTypeUserSelected() {
        return testType;
    }

    public String getUsername()
    {
        return username;
    }
}
