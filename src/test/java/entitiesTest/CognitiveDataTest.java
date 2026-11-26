package entitiesTest;
import entities.CognitiveData;
import java.util.*;
import java.time.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CognitiveDataTest {
    CognitiveData data;

    @BeforeEach
    void setUp() {
        this.data = new CognitiveData.CogBuilder(LocalDate.of(1970,1, 1)).build();
    }

    @Test
    void correctBuildTestEmpty() {
        LocalDate date = LocalDate.of(1970, 1, 1);
        Hashtable<LocalDate, Object[]> expected = new Hashtable<LocalDate, Object[]> ();
        Object[] cogTest = {"blank", 0.0};
        Object[] put = {"none", cogTest, 0.0};
        expected.put(date, put);

        assertEquals(expected, data.getCognitiveResults());
    }

    /**
     * test the getters
     */
    @Test
    void builderSetsFields() {
        LocalDate d = LocalDate.now();
        CognitiveData data = new CognitiveData.CogBuilder(d)
                .mood("happy")
                .cogTest("CogSci", 85.0)
                .productivityRating(7.0)
                .build();

        assertEquals(d, data.getDate());
        assertEquals("happy", data.getMood());
        assertEquals(85.0, data.getCogTestResult());
        assertEquals(7.0, data.getProductivityRating());
    }

    @Test
    void builderUsesDefaults() {
        CognitiveData data = new CognitiveData.CogBuilder(LocalDate.now()).build();
        assertEquals("none", data.getMood());
        assertEquals(0.0, data.getProductivityRating());
    }

    @Test
    void cogTestTypeGetterReturnsBuilderValue() {
        CognitiveData data = new CognitiveData.CogBuilder(LocalDate.now()).cogTest("Memory", 42.5).build();

        assertEquals("Memory", data.getCogTestType());
        assertEquals(42.5, data.getCogTestResult());
    }

    @Test
    void cogTestDefaultsAreBlankAndZero() {
        assertEquals("blank", data.getCogTestType());
        assertEquals(0.0, data.getCogTestResult());
    }

    @Test
    void getCognitiveResultsReflectsAllBuilderFields() {
        LocalDate d = LocalDate.ofEpochDay(0);
        CognitiveData full = new CognitiveData.CogBuilder(d)
                .mood("happy")
                .cogTest("Attention", 8.0)
                .productivityRating(7.0)
                .build();

        Hashtable<LocalDate, Object[]> results = full.getCognitiveResults();

        assertEquals(1, results.size());
        Object[] row = results.get(d);
        assertEquals("happy", row[0]);
        assertArrayEquals(new Object[]{"Attention", 8.0}, (Object[]) row[1]);
        assertEquals(7.0, row[2]);
    }

    @Test
    void laterBuilderCallsOverrideEarlierOnes() {
        CognitiveData overridden = new CognitiveData.CogBuilder(LocalDate.now())
                .mood("sad").mood("happy")
                .productivityRating(1.0).productivityRating(9.0)
                .build();

        assertEquals("happy", overridden.getMood());
        assertEquals(9.0, overridden.getProductivityRating());
    }
}
