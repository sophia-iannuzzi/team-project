package use_case.MemoryTest;

/**
 * Input Boundary for the Memory Use Case.
 */

public interface MemoryTestInputBoundary {
    // Executes the Memory Test Use Case
    void userStartsMemorizationTest(MemoryTestInputData CognitiveDataInput);

    void userSubmitsAnswers(String answer);

    void userFinishesTest();
}
