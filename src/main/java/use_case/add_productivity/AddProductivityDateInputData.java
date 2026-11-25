package use_case.add_productivity;

public class AddProductivityDateInputData {
    private final String date;
    private final String username;

    public AddProductivityDateInputData(String date, String username){
        this.date = date;
        this.username = username;
    }

    public String getDate() {return date;}
    public String getUsername() {return this.username;}
}
