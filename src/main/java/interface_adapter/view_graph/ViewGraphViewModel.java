package interface_adapter.view_graph;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class ViewGraphViewModel {
    public final String TITLE = "See my productivity with:";
    public final String MOOD_LABEL = "Moods";
    public final String SCORE_LABEL = "Scores";
    public final String RETURN = "Return";

    public final String VIEW_NAME = "user view graph";

    private final List<ViewGraphModelListener> listeners = new ArrayList<>();


    public ViewGraphState state = new ViewGraphState();

    public void setState(ViewGraphState state) { this.state = state; }

    public ViewGraphState getState() { return this.state; }

    public void addListener(ViewGraphModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (ViewGraphModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
