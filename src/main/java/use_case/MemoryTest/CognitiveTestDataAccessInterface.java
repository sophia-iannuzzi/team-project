package use_case.MemoryTest;

/**
 * DAO Interface for the Memory Use Case; handles storing user score in external API.
 */

public interface CognitiveTestDataAccessInterface {

    void saveUserAttemptTest(String username, boolean doneTest, String testType, double score) ;
}
