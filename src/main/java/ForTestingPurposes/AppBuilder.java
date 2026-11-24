package ForTestingPurposes;

import entities.RegularUser;
import interface_adapter.AttentionTest.AttentionTestViewModel;
import interface_adapter.MemoryTest.MemoryTestViewModel;
import usecase.TestSelection.TestSelectionInputBoundary;
import usecase.TestSelection.TestSelectionInteractor;
import usecase.TestSelection.TestSelectionOutputBoundary;
import interface_adapter.TestSelection.TestSelectionController;
import interface_adapter.TestSelection.TestSelectionPresenter;
import view.AttentionTestView;
import view.MemoryTestView;
import view.TestSelectionView;
import interface_adapter.TestSelection.TestSelectionViewModel;
import ViewManager.ViewManager;
import ViewManager.ViewManagerModel;

import javax.swing.*;
import java.awt.*;

public class AppBuilder {

    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
//     final UserFactory userFactory = new UserFactory();

    final ViewManagerModel viewManagerModel = new ViewManagerModel();
    ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    private TestSelectionView testSelectionView;
    private TestSelectionViewModel testSelectionViewModel;
    private MemoryTestViewModel memoryTestViewModel;
    private AttentionTestViewModel attentionTestViewModel;
    private MemoryTestView memoryTestView;
    private AttentionTestView attentionTestView;

    final RegularUser regularUser = new RegularUser("TestUser");
    final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject(regularUser);
    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    public AppBuilder addTestSelectionView()
    {
        testSelectionViewModel = new TestSelectionViewModel();
        testSelectionView = new TestSelectionView(testSelectionViewModel);
        cardPanel.add(testSelectionView, testSelectionViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addMemoryTestView() {
        memoryTestViewModel = new MemoryTestViewModel();
        memoryTestView = new MemoryTestView(memoryTestViewModel);
        cardPanel.add(memoryTestView, memoryTestViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addAttentionTestView() {
        attentionTestViewModel = new AttentionTestViewModel();
        attentionTestView = new AttentionTestView(attentionTestViewModel);
        cardPanel.add(attentionTestView, attentionTestViewModel.VIEW_NAME);
        return this;
    }

    public AppBuilder addTestSelectionUseCase()
    {
        final TestSelectionOutputBoundary testSelectionOutputBoundary = new TestSelectionPresenter(viewManagerModel,
                testSelectionViewModel, memoryTestViewModel, attentionTestViewModel);


        final TestSelectionInputBoundary testSelectionInteractor = new TestSelectionInteractor(
                userDataAccessObject, testSelectionOutputBoundary);

        TestSelectionController controller = new TestSelectionController(testSelectionInteractor);
        testSelectionView.setTestSelectionController(controller);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("User Test Selection Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(testSelectionViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();

        return application;
    }
}
