package use_case.MemoryTest;

import java.util.List;

/**
 * DAO Interface for the Memory Use Case; handles randomizing and generating words.
 */

public interface MemoryTestDataAccessInterface {
    List<String> getRandomWords(int count);
}
