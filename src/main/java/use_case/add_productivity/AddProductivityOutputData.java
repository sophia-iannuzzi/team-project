package use_case.add_productivity;

import java.time.LocalDate;

public class AddProductivityOutputData {
    private final Double rating;
    private final LocalDate date;

    public AddProductivityOutputData(Double rating, LocalDate date){
        this.rating = rating;
        this.date = date;
    }

    public Double getRating() {return this.rating;}
    public LocalDate getDate() {return this.date;}
}
