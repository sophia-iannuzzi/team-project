package interface_adapter.view_graph;
import use_case.view_graph.ViewGraphOutputBoundry;
import use_case.view_graph.ViewGraphOutputData;

public class ViewGraphPresenter implements ViewGraphOutputBoundry {
    // viewmodel
    private GraphVisualMaker graphMaker;

    //SHOULD ALSO REQUIRE viewmodel
    ViewGraphPresenter(GraphVisualMaker graphMaker) {
        this.graphMaker = graphMaker;
    }

    public void prepareSuccessView(ViewGraphOutputData viewGraphOutputData) {
        // should call to GraphVisualMaker
        // should call to viewmodel
    }
}
