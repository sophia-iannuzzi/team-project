package interface_adapter.add_mood;
import java.time.*;

/**
 * My state for the Mood related views
 */
public class AddMoodState {
    private LocalDate date;
    private String mood = "none";
    private String username = "";
    private String error = "";
    private String message = "";

    // Setters and getters for the State attributes
    public void setMood(String mood) {this.mood = mood;}
    public String getMood() {return this.mood;}
    public void setDate(LocalDate date) {this.date = date;}
    public LocalDate getDate() {return this.date;}
    public void setUsername(String username){this.username = username;}
    public String getUsername() {return this.username;}
    public void setError(String error) {this.error = error;}
    public String getError(){return this.error;}
    public void setMessage(String message) {this.message = message;}
    public String getMessage() {return this.message;}
}
