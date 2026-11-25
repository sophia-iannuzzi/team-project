package use_case.add_productivity;

import java.time.LocalDate;

public class AddProductivityInputData {
    private final Double rating;
    private final LocalDate date;
    private final String username;

    public AddProductivityInputData(String username, LocalDate date, Double rating){
        this.rating = rating;
        this.date = date;
        this.username = username;
    }

    public Double getRating() {return this.rating;}
    public LocalDate getDate() {return this.date;}
    public String getUsername() { return this.username;}
}
