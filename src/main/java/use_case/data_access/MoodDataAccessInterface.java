package use_case.data_access;

import entities.CognitiveData;
import java.time.*;

public interface MoodDataAccessInterface {
    CognitiveData[] getCognitiveData(String username);

    void updateMood(String username, LocalDate date, String mood);
}

