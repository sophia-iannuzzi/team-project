package use_case.MemoryTest;

/**
 * Input Data for the Memory Use Case.
 */

public class MemoryTestInputData {
    private final String username;

    public MemoryTestInputData(String username)
    {
        this.username = username;
    }

    String getUsername() {
        return username;
    }
}
