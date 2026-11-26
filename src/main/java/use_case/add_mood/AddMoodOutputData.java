package use_case.add_mood;
import java.time.*;

public class AddMoodOutputData {
    private final String mood;
    private final LocalDate date;
    private final String username;

    public AddMoodOutputData(LocalDate date, String username){
        this.mood = "none";
        this.date = date;
        this.username = username;
    }
    public AddMoodOutputData(String mood, LocalDate date, String username){
        this.mood = mood;
        this.date = date;
        this.username = username;
    }

    public String getMood() {return this.mood;}
    public LocalDate getDate() {return this.date;}
    public String getUsername() {return this.username;}
}
