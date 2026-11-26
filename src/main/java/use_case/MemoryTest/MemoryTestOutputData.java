package use_case.MemoryTest;

import java.util.List;

/**
 * Output Data for the Memory Use Case.
 */

public class MemoryTestOutputData {
    private final String username;
    private final int score;
    private final int totalWords;
    private final List<String> correctWords;
    private final List<String> missedWords;

    public MemoryTestOutputData(String username, int score, int totalWords,
                                List<String> correctWords, List<String> missedWords) {
        this.username = username;
        this.score = score;
        this.totalWords = totalWords;
        this.correctWords = correctWords;
        this.missedWords = missedWords;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return score;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public List<String> getCorrectWords() {
        return correctWords;
    }

    public List<String> getMissedWords() {
        return missedWords;
    }
}
