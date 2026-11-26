package interface_adapter.MemoryTest;

import java.util.ArrayList;
import java.util.List;

/**
 * The State information representing the user who selected and is doing a cognitive memory test.
 */

public class MemoryTestState {

    private String username = "";
    private MemoryTestGameState gameState = MemoryTestGameState.MEMORIZATION;
    private String answerInput = "";
    private int remainingSeconds = 0;
    private List<String> selectedWords = new ArrayList<>(); // words to display
    private List<String> submittedAnswers = new ArrayList<>();
    private List<String> correctWords = new ArrayList<>();
    private List<String> missedWords = new ArrayList<>();
    private int score = 0;
    private int totalWords = 8;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public MemoryTestGameState getGameState() {
        return gameState;
    }

    public void setGameState(MemoryTestGameState gameState) {
        this.gameState = gameState;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalWords() {
        return totalWords;
    }

    public void setTotalWords(int totalWords) {
        this.totalWords = totalWords;
    }

    public List<String> getSelectedWords() {
        return new ArrayList<>(selectedWords);
    }

    public void setSelectedWords(List<String> selectedWords) {
        this.selectedWords = new ArrayList<>(selectedWords);
    }

    public List<String> getSubmittedAnswers() {
        return new ArrayList<>(submittedAnswers);
    }

    public void setSubmittedAnswers(List<String> submittedAnswers) {
        this.submittedAnswers = new ArrayList<>(submittedAnswers);
    }

    public List<String> getCorrectWords() {
        return new ArrayList<>(correctWords);
    }

    public void setCorrectWords(List<String> correctWords) {
        this.correctWords = new ArrayList<>(correctWords);
    }

    public List<String> getMissedWords() {
        return new ArrayList<>(missedWords);
    }

    public void setMissedWords(List<String> missedWords) {
        this.missedWords = new ArrayList<>(missedWords);
    }

    public String getAnswerInput() {
        return answerInput;
    }

    public void setAnswerInput(String answerInput) {
        this.answerInput = answerInput;
    }

    public int getRemainingSeconds() {
        return remainingSeconds;
    }

    public void setRemainingSeconds(int remainingSeconds) {
        this.remainingSeconds = remainingSeconds;
    }
}
