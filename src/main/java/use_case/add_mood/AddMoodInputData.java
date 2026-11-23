package use_case.add_mood;
import java.util.*;

public class AddMoodInputData {
    private final String mood;
    private final Date date;

    public AddMoodInputData(String mood, Date date){
        this.mood = mood;
        this.date = date;
    }

    public String getMood() {return mood;}
    public Date getDate() {return date;}
}
