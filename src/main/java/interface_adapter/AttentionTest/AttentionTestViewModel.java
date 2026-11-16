package interface_adapter.AttentionTest;

import java.util.ArrayList;
import java.util.List;

public class AttentionTestViewModel {

    private final List<AttentionTestViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "Attention Test";

    private AttentionTestState state = new AttentionTestState();

    public AttentionTestState getState() {
        return this.state;
    }

    public void setState(AttentionTestState state) {
        this.state = state;
    }

    public void addListener(AttentionTestViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (AttentionTestViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
