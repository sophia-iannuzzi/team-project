package interface_adapter.TestSelection;

import java.util.ArrayList;
import java.util.List;

public class TestSelectionViewModel {
    private final List<TestSelectionViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "Test Selection";

    private TestSelectionState state = new TestSelectionState();

    public TestSelectionState getState() {
        return this.state;
    }

    public void setState(TestSelectionState state) {
        this.state = state;
    }

    public void addListener(TestSelectionViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (TestSelectionViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
