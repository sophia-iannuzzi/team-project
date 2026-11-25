package use_case.add_productivity;

import java.time.LocalDate;

public class AddProductivityOutputData {
    private final Float rating;
    private final LocalDate date;

    public AddProductivityOutputData(Float rating, LocalDate date){
        this.rating = rating;
        this.date = date;
    }

    public Float getRating() {return this.rating;}
    public LocalDate getDate() {return this.date;}
}
