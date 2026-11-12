package entities;
import java.util.*;

/**
 * An entity representing a user's cognitive data.
 */
public class CognitiveData {
    private Date date;
    private String mood;
    private String cogTestType;
    private Double cogTestResult;
    private Double productivityRating;

    /**
     * Creates a CognitiveData using a CogBuilder.
     * @param b the builder used to create the object.
     */
    private CognitiveData(CogBuilder b) {
        this.date = b.date;
        this.mood = b.mood;
        this.cogTestType = b.cogTestType;
        this.cogTestResult = b.cogTestResult;
        this.productivityRating = b.productivityRating;
    }

    /**
     *  CognitiveData class builder (follows Creational Builder design pattern)
     */
    public static class CogBuilder {
        private Date date;
        private String mood;
        private String cogTestType;
        private Double cogTestResult;
        private Double productivityRating;

        public CogBuilder(Date date) {
            this.date = date;
        }

        public CogBuilder mood(String mood) {
            this.mood = mood;
            return this;
        }

        public CogBuilder cogTestType(String cogTestType) {
            this.cogTestType = cogTestType;
            return this;
        }

        public CogBuilder cogTestResult(Double cogTestResult) {
            this.cogTestResult = cogTestResult;
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
     * Returns a Hashtable, with nested arrays, representing this CognitiveData of the format:
     * {date : {mood, {cogTestType, cogTestResult}, productivityRating}
     */
    private Hashtable<Date, Object[]> getCogntivieResutls() {
        Hashtable<Date, Object[]> dict = new Hashtable<Date, Object[]>();
        Object[] cogInfo = {this.cogTestType, this.cogTestResult};
        Object[] list = {this.mood, cogInfo, this.productivityRating};
        dict.put(this.date, list);

        return dict;
    }

}
