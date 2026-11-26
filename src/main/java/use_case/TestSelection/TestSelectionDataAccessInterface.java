package use_case.TestSelection;

import entities.RegularUser;

/**
 * DAO Interface for the Test Selection Use Case.
 */

public interface TestSelectionDataAccessInterface {

    void save(RegularUser user);

    RegularUser get(String username);

    void saveUserAttemptTest(String username, boolean doneTest, String testType, double score) ;
}
