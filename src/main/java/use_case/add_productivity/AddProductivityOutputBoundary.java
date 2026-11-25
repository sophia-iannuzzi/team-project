package use_case.add_productivity;

import java.time.LocalDate;

public interface AddProductivityOutputBoundary {


    public void prepareInvalidDateView(String error_message);

    public void prepareExistingMoodView(String issue_message);

    public void prepareAddMoodView(LocalDate date);

    void prepareSuccessView(AddProductivityOutputData addProductivityOutputData);
}
