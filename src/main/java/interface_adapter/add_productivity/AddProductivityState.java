package interface_adapter.add_productivity;

import java.time.LocalDate;

public class AddProductivityState {
    private LocalDate date;
    private Double rating= 0.0;
    private String username = "";
    private String error = "";
    private String message = "";

    // Setters and getters for the State attributes
    public void setRating(Double rating) {this.rating = rating;}
    public Double getProductivityRating() {return this.rating;}
    public void setDate(LocalDate date) {this.date = date;}
    public LocalDate getDate() {return this.date;}
    public void setUsername(String username){this.username = username;}
    public String getUsername() {return this.username;}
    public void setError(String error) {this.error = error;}
    public String getError(){return this.error;}
    public void setMessage(String message) {this.message = message;}
    public String getMessage() {return this.message;}
}
