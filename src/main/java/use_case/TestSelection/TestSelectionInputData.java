package use_case.TestSelection;

/**
 * Input data for the Test Selection Use Case.
 */

public class TestSelectionInputData {

    private final String username;
    private final boolean hasDoneTest;
    private final String testType;

    public TestSelectionInputData(String username, boolean hasDoneTest, String testType)
    {
        this.username = username;
        this.hasDoneTest = hasDoneTest;
        this.testType = testType;
    }

    public String getUsername() {
        return username;
    }

    public boolean getUserHasDoneTest() {return hasDoneTest;}

    public String getTestType() { return testType;}
}
