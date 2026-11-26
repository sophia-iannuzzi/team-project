package use_case.add_mood;

public class AddMoodDateInputData {
    private final String date;
    private final String username;

    public AddMoodDateInputData(String date, String username){
        this.date = date;
        this.username = username;
    }

    public String getDate() {return date;}
    public String getUsername() {return this.username;}
}
