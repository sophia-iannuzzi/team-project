package use_case.add_mood;

import java.time.LocalDate;

public class AddMoodInputData {
    private final String mood;
    private final LocalDate date;
    private final String username;

    public AddMoodInputData(String mood, LocalDate date, String username){
        this.mood = mood;
        this.date = date;
        this.username = username;
    }

    public String getMood() {return mood;}
    public LocalDate getDate() {return date;}
    public String getUsername() {return this.username;}
}
