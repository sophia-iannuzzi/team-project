package ForTestingCognitiveTests.ViewManager;

import java.util.ArrayList;
import java.util.List;

public class CognitiveTestViewManagerModel {
    // Model for the View Manager. Its state is the name of the View which
    // is currently active. An initial state of "" is used.

    private final List<CognitiveTestViewManagerModelListener> listeners = new ArrayList<>();

    private String currentViewName = "";

    public String getCurrentViewName() {
        return this.currentViewName;
    }

    public void setState(String currentViewName) {
        this.currentViewName = currentViewName;
    }

    public void addListener(CognitiveTestViewManagerModelListener listener) {
        listeners.add(listener);
    }

    public void notifyViewChanged() {
        for (CognitiveTestViewManagerModelListener listener : listeners) {
            listener.viewChanged();
        }
    }
}
