package interface_adapter.view_graph;
import ViewManager.ViewManagerModel;
import use_case.view_graph.ViewGraphOutputBoundry;
import use_case.view_graph.ViewGraphOutputData;

public class ViewGraphPresenter implements ViewGraphOutputBoundry {
    private final ViewManagerModel viewManagerModel;
    private final ViewGraphViewModel viewGraphViewModel;

    public ViewGraphPresenter(ViewManagerModel viewManagerModel, ViewGraphViewModel viewGraphViewModel) {
        this.viewGraphViewModel = viewGraphViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    public void prepareSuccessView(ViewGraphOutputData outputData) {
        ViewGraphState state = viewGraphViewModel.getState();

        // sets the need for a graph to be true
        state.setNeedGraph();

        // set titles
        state.setTitle(outputData.getxAxis() + " vs " + outputData.getyAxis());
        state.setxTitle(outputData.getxAxis());
        state.setyTitle(outputData.getyAxis());

        // set values
        state.setyValues(outputData.getyValues());
        state.setxValues(outputData.getxValues());

        state.setType(outputData.getType());

        viewManagerModel.setState(viewGraphViewModel.VIEW_NAME);
        viewGraphViewModel.setState(state);
        viewGraphViewModel.notifyStateChanged();
    }

    public void prepareReturnView(){}
}
