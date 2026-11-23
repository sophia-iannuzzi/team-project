package use_case.add_productivity;

import java.util.Date;
import java.util.*;

public class AddProductivityInputData {
    private final Float rating;
    private final Date date;

    public AddProductivityInputData(Float rating, Date date){
        this.rating = rating;
        this.date = date;
    }

    public Float getRating() {return this.rating;}
    public Date getDate() {return this.date;}
}
