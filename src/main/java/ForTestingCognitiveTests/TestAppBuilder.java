package ForTestingCognitiveTests;

import data_access.InMemoryTestDataAccessInterface;
import entities.RegularUser;
import interface_adapter.AttentionTest.AttentionTestViewModel;
import interface_adapter.MemoryTest.MemoryTestController;
import interface_adapter.MemoryTest.MemoryTestPresenter;
import interface_adapter.MemoryTest.MemoryTestViewModel;
import interface_adapter.MemoryTest.MemoryTestViews;
import use_case.MemoryTest.MemoryTestInputBoundary;
import use_case.MemoryTest.MemoryTestInteractor;
import use_case.MemoryTest.MemoryTestOutputBoundary;
import use_case.TestSelection.TestSelectionInputBoundary;
import use_case.TestSelection.TestSelectionInteractor;
import use_case.TestSelection.TestSelectionOutputBoundary;
import interface_adapter.TestSelection.TestSelectionController;
import interface_adapter.TestSelection.TestSelectionPresenter;
import view.*;
import interface_adapter.TestSelection.TestSelectionViewModel;
import ForTestingCognitiveTests.ViewManager.CognitiveTestViewManager;
import ForTestingCognitiveTests.ViewManager.CognitiveTestViewManagerModel;

import javax.swing.*;
import java.awt.*;

public class TestAppBuilder {

    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
//     final UserFactory userFactory = new UserFactory();

    final CognitiveTestViewManagerModel viewManagerModel = new CognitiveTestViewManagerModel();
    CognitiveTestViewManager viewManager = new CognitiveTestViewManager(cardPanel, cardLayout, viewManagerModel);

    private TestSelectionView testSelectionView;
    private TestSelectionViewModel testSelectionViewModel;
    private MemoryTestViewModel memoryTestViewModel;
    private AttentionTestViewModel attentionTestViewModel;
    private MemorizationView memorizationView;
    private AttentionTestView attentionTestView;
    private AnsweringView answeringView;
    private MemoryTestResultsView memoryTestResultsView;

    final RegularUser regularUser = new RegularUser("TestUser");
    final TestInMemoryUserDataAccessObject userDataAccessObject = new TestInMemoryUserDataAccessObject(regularUser);
    final InMemoryTestDataAccessInterface memoryTestDataAccessObject = new InMemoryTestDataAccessInterface();
    public TestAppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    public TestAppBuilder addTestSelectionView()
    {
        testSelectionViewModel = new TestSelectionViewModel();
        testSelectionView = new TestSelectionView(testSelectionViewModel);
        cardPanel.add(testSelectionView, testSelectionViewModel.VIEW_NAME);
        return this;
    }

    public TestAppBuilder addMemoryTestView() {
        memoryTestViewModel = new MemoryTestViewModel();

        memorizationView = new MemorizationView(memoryTestViewModel);
        answeringView = new AnsweringView(memoryTestViewModel);
        memoryTestResultsView = new MemoryTestResultsView(memoryTestViewModel);

        cardPanel.add(memorizationView, MemoryTestViews.MEMORIZATION);
        cardPanel.add(answeringView, MemoryTestViews.ANSWERING);
        cardPanel.add(memoryTestResultsView, MemoryTestViews.RESULTS);
        return this;
    }

    public TestAppBuilder addAttentionTestView() {
        attentionTestViewModel = new AttentionTestViewModel();
        attentionTestView = new AttentionTestView(attentionTestViewModel);
        cardPanel.add(attentionTestView, attentionTestViewModel.VIEW_NAME);
        return this;
    }

    public TestAppBuilder addTestSelectionUseCase()
    {
        final TestSelectionOutputBoundary testSelectionOutputBoundary = new TestSelectionPresenter(viewManagerModel,
                testSelectionViewModel, memoryTestViewModel, attentionTestViewModel);


        final TestSelectionInputBoundary testSelectionInteractor = new TestSelectionInteractor(
                userDataAccessObject, testSelectionOutputBoundary);

        TestSelectionController controller = new TestSelectionController(testSelectionInteractor);
        testSelectionView.setTestSelectionController(controller);
        return this;
    }

    public TestAppBuilder addMemoryTestUseCase() {
        MemoryTestOutputBoundary memoryTestOutputBoundary =
                new MemoryTestPresenter(memoryTestViewModel, viewManagerModel);

        MemoryTestInputBoundary memoryTestInteractor =
                new MemoryTestInteractor(
                        memoryTestOutputBoundary,
                        memoryTestDataAccessObject, userDataAccessObject

                );

        MemoryTestController memoryTestController = new MemoryTestController(memoryTestInteractor);

        memorizationView.setMemoryTestController(memoryTestController);
        answeringView.setMemoryTestController(memoryTestController);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("User Test Selection Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        application.add(cardPanel);

        viewManagerModel.setState(TestSelectionViewModel.VIEW_NAME);
        viewManagerModel.notifyViewChanged();

        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);

        return application;
    }
}
