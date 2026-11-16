package interface_adapter.MemoryTest;

import java.util.ArrayList;
import java.util.List;

public class MemoryTestViewModel {

    private final List<MemoryTestViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "Memory Test";

    private MemoryTestState state = new MemoryTestState();

    public MemoryTestState getState() {
        return this.state;
    }

    public void setState(MemoryTestState state) {
        this.state = state;
    }

    public void addListener(MemoryTestViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (MemoryTestViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
