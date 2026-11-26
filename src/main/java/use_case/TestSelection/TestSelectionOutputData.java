package use_case.TestSelection;

/**
 * Output data for the Test Selection Use Case.
 */

public class TestSelectionOutputData {
    private final String testType;
    private final String username;

    public TestSelectionOutputData(String username, String testType)
    {
        this.username = username;
        this.testType = testType;
    }

    public String getTestTypeUserSelected() {
        return testType;
    }

    public String getUsername()
    {
        return username;
    }
}
