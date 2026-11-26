package use_case.view_graph;
import entities.CognitiveData;

/**
 * Database access interface for ViewGraph use case.
 */
public interface ViewGraphDataAccessInterface {
    /**
     * Searches for the cognitivedata of user (username) from the storage.
     * @param username the username of the current user.
     * @return an array of the user's cognitivedata.
     */
    CognitiveData[] getData(String username);
}
