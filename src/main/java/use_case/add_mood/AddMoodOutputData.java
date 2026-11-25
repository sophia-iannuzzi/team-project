package use_case.add_mood;
import java.time.*;

public class AddMoodOutputData {
    private final String mood;
    private final LocalDate date;

    public AddMoodOutputData(LocalDate date){
        this.mood = "none";
        this.date = date;
    }
    public AddMoodOutputData(String mood, LocalDate date){
        this.mood = mood;
        this.date = date;
    }

    public String getMood() {return this.mood;}
    public LocalDate getDate() {return this.date;}
}
