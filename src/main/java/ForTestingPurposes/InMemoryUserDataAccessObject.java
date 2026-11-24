package ForTestingPurposes;

import entities.CognitiveData;
import entities.RegularUser;
import usecase.TestSelection.TestSelectionDataAccessInterface;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements TestSelectionDataAccessInterface {

    private final Map<RegularUser, CognitiveData> accounts = new HashMap<>();
    private String currentUsername;

    public InMemoryUserDataAccessObject(RegularUser user) {
        accounts.put(user, new CognitiveData.CogBuilder(new java.util.Date()).build());
        currentUsername = user.getUsername();
    }

    @Override
    public void save(RegularUser user) {
        accounts.put(user, accounts.get(user));
    }

    @Override
    public RegularUser get(String username) {
        for (RegularUser user : accounts.keySet()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public void saveUserAttemptTest(String username, boolean doneTest, String testType) {

        RegularUser user = get(username);
        if (user == null) {return;}
        if (doneTest){ user.doneTest();}

        CognitiveData oldData = accounts.get(user);

        CognitiveData newData = new CognitiveData.CogBuilder(new Date())
                .mood("Happy") // need getter for getting mood oldData.getMood()
                .cogTest(testType, 0.0) // need getter for score
                .productivityRating(55.5) // need getter for productivity
                .build();

        accounts.put(user, newData);
    }
}
