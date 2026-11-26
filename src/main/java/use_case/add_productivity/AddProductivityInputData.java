package use_case.add_productivity;

public class AddProductivityInputData {
    private final String rating;
    private final String date;
    private final String username;

    public AddProductivityInputData(String username, String date, String rating){
        this.rating = rating;
        this.date = date;
        this.username = username;
    }

    public String getRating() {return this.rating;}
    public String getDate() {return this.date;}
    public String getUsername() { return this.username;}
}
