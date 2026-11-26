package view.TestUserGraphView;

import ViewManager.ViewManagerModel;
import ViewManager.ViewManagerModelListener;
import interface_adapter.view_graph.ViewGraphController;
import interface_adapter.view_graph.ViewGraphPresenter;
import interface_adapter.view_graph.ViewGraphViewModel;
import use_case.view_graph.*;
import view.UserViewGraphView;

import javax.swing.*;

public class TestView {
    // for testing & temporary viewing of view
    public static void main(String[] args) {
        // faux app builder
        ViewGraphDataAccessInterface dBAccess = new fauxDB();
        ViewManagerModel VMM = new ViewManagerModel();
        ViewGraphViewModel ViewGraphVM = new ViewGraphViewModel();
        ViewGraphOutputBoundry presenter = new ViewGraphPresenter(VMM, ViewGraphVM);
        ViewGraphInputBoundry interactor = new ViewGraphInteractor(dBAccess, presenter);
        UserViewGraphView u = new UserViewGraphView(ViewGraphVM, new ViewGraphController(interactor));

        ViewGraphVM.addListener(u);

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setContentPane(u);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
