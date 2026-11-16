package usecase.TestSelection;

import entities.RegularUser;

public interface TestSelectionDataAccessInterface {

    void save(RegularUser user);

    RegularUser get(String username);

    void saveUserAttemptTest(String username, boolean doneTest, String testType);
}
