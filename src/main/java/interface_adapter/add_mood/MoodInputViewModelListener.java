package interface_adapter.add_mood;

import java.awt.event.ActionEvent;

public interface MoodInputViewModelListener {
    // Listen for when the state of the Mood Input has been changed
    void stateChanged();

    void ActionPerformed(ActionEvent e);
}
