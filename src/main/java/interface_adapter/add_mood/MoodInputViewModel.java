package interface_adapter.add_mood;
import java.util.*;

/**
 * Listen for changes to the Add View Model
 */
public class MoodInputViewModel {
    public static final String VIEW_NAME = "add mood";
    private final List<MoodInputViewModelListener> listeners = new ArrayList<>();
    private AddMoodState moodState = new AddMoodState();

    // Getters and Setters
    public AddMoodState getState() { return this.moodState;}
    public void setMoodState(AddMoodState state){this.moodState = state;}
    public String getViewName() {return VIEW_NAME;}

    public void addListener(MoodInputViewModelListener listener){this.listeners.add(listener);}

    /**
     * Record that the view state has changed
     */
    public void notifyStateChanged() {
        for(int i = 0; i < listeners.size(); i +=1){
            listeners.get(i).stateChanged();
        }
    }
}
