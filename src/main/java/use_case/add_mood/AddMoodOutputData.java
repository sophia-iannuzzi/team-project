package use_case.add_mood;
import java.util.*;

public class AddMoodOutputData {
    private final String mood;
    private final Date date;

    public AddMoodOutputData(Date date){
        this.mood = "none";
        this.date = date;
    }
    public AddMoodOutputData(String mood, Date date){
        this.mood = mood;
        this.date = date;
    }

    public String getMood() {return this.mood;}
    public Date getDate() {return this.date;}
}
