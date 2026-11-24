package ForTestingCognitiveTests;

import entities.RegularUser;

public class UserFactory {

    public RegularUser create(String name) {
        return new RegularUser(name);
    }

}
