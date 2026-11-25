package entitiesTest;
import entities.CognitiveData;
import java.util.*;
import java.time.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
