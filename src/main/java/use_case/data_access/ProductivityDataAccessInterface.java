package use_case.data_access;

import entities.CognitiveData;
import java.time.*;

public interface ProductivityDataAccessInterface {
    CognitiveData[] getCognitiveData(String username);

    void updateProductivity(String username, LocalDate date, Double productivity);
}
