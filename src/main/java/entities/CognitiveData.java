package entities;
import java.util.*;
import java.time.*;

/**
 * An entity representing a user's cognitive data.
 */
public class CognitiveData {
    private LocalDate date;
    private String mood;
    private Object[] cogTest;
    private Double productivityRating;

    /**
     * Creates a CognitiveData using a CogBuilder.
     * @param b the builder used to create the object.
     */
    private CognitiveData(CogBuilder b) {
        this.date = b.date;
        this.mood = b.mood;
        this.cogTest = b.cogTest;
        this.productivityRating = b.productivityRating;
    }

    /**
     *  CognitiveData class builder (follows Creational Builder design pattern)
     */
    public static class CogBuilder {
        private LocalDate date;
        private String mood = "none";
        private Object[] cogTest = {"blank", 0.0};
        private Double productivityRating = 0.0;

        public CogBuilder(LocalDate date) {
            this.date = date;
        }

        public CogBuilder mood(String mood) {
            this.mood = mood;
            return this;
        }

        public CogBuilder cogTest(String cogTestType, Double cogTestResult) {
            this.cogTest = new Object[]{cogTestType, cogTestResult};
            return this;
        }

        public CogBuilder productivityRating(Double productivityRating) {
            this.productivityRating = productivityRating;
            return this;
        }

        public CognitiveData build() {
            return new CognitiveData(this);
        }

    }

    /**
     * @return the date
     */
    public LocalDate getDate() { return this.date; }

    /**
     * @return the productivity rating
     */
    public double getProductivityRating() { return this.productivityRating; }

    /**
     * @return the cognitive test (returns an array of: {cognitive test type, cognitive test score})
     */
    public Object[] getCognitiveTest() { return this.cogTest; }

    /**
     * @return the mood
     */
    public String getMood() { return this.mood;}

    /**
     * @return the cog test result
     */
    public Double getCogTestResult() {return (Double) this.cogTest[1];}

    /**
     * @return the cog test type
     */
    public String getCogTestType() { return (String) this.cogTest[0];}

    /**
     * Returns a Hashtable, with nested arrays, representing this CognitiveData of the format:
     * {date : [mood, cogTest, productivityRating]}
     */
    public Hashtable<LocalDate, Object[]> getCognitiveResults() {
        Hashtable<LocalDate, Object[]> dict = new Hashtable<LocalDate, Object[]>();
        Object[] list = {this.mood, this.cogTest, this.productivityRating};
        dict.put(this.date, list);
        return dict;
    }

}
