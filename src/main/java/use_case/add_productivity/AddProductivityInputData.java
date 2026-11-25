package use_case.add_productivity;

public class AddProductivityInputData {
    private final Float rating;
    private final String date;

    public AddProductivityInputData(Float rating, String date){
        this.rating = rating;
        this.date = date;
    }

    public Float getRating() {return this.rating;}
    public String getDate() {return this.date;}
}
