package use_case.TestSelection;

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

    String getUsername() {
        return username;
    }

    boolean getUserHasDoneTest() {return hasDoneTest;}

    public String getTestType() { return testType;}
}
