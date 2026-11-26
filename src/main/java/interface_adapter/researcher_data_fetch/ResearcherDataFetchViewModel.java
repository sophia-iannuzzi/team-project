package interface_adapter.researcher_data_fetch;

import java.util.ArrayList;
import java.util.List;

public class ResearcherDataFetchViewModel {
    private final List<ResearcherDataFetchViewModelListener> listeners = new ArrayList<>();

    public static final String VIEW_NAME = "data fetch";

    private ResearcherDataFetchState state = new ResearcherDataFetchState();

    public ResearcherDataFetchState getState() {
        return this.state;
    }

    public void setState(ResearcherDataFetchState state) {
        this.state = state;
    }

    public void addListener(ResearcherDataFetchViewModelListener listener) {
        listeners.add(listener);
    }

    public void notifyStateChanged() {
        for (ResearcherDataFetchViewModelListener listener : listeners) {
            listener.stateChanged();
        }
    }
}
