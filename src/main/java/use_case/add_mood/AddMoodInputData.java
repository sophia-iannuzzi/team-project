package use_case.add_mood;

public class AddMoodInputData {
    private final String mood;
    private final String date;
    private final String username;

    public AddMoodInputData(String mood, String date, String username){
        this.mood = mood;
        this.date = date;
        this.username = username;
    }

    public String getMood() {return mood;}
    public String getDate() {return date;}
    public String getUsername() {return this.username;}
}
