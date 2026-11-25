package use_case.add_productivity;

import java.time.LocalDate;

public class AddProductivityInputData {
    private final String rating;
    private final LocalDate date;
    private final String username;

    public AddProductivityInputData(String username, LocalDate date, String rating){
        this.rating = rating;
        this.date = date;
        this.username = username;
    }

    public String getRating() {return this.rating;}
    public LocalDate getDate() {return this.date;}
    public String getUsername() { return this.username;}
}
