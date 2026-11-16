package view;

import interface_adapter.TestSelection.TestSelectionState;
import interface_adapter.TestSelection.TestSelectionViewModelListener;
import interface_adapter.TestSelection.TestSelectionController;
import interface_adapter.TestSelection.TestSelectionViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestSelectionView extends JPanel implements ActionListener, TestSelectionViewModelListener {

    private final TestSelectionViewModel testSelectionViewModel;
    private final JButton memoryTest;
    private final JButton attentionTest;
    private final JButton back;
    private final JLabel testErrorField = new JLabel();
    private TestSelectionController testSelectionController = null;

    public TestSelectionView(TestSelectionViewModel testSelectionViewModel)
    {

        this.testSelectionViewModel = testSelectionViewModel;
        this.testSelectionViewModel.addListener(this);

        final JLabel title = new JLabel("Test Selection");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel buttons = new JPanel();
        memoryTest = new JButton("Memory Test");
        buttons.add(memoryTest);

        attentionTest = new JButton("Attention Test");
        buttons.add(attentionTest);

        back = new JButton("Back");
        buttons.add(back);

        memoryTest.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(memoryTest)) {
                            final TestSelectionState currentState = testSelectionViewModel.getState();

                            testSelectionController.execute(
                                    currentState.getUsername(),
                                    currentState.getTestDone(),
                                    currentState.getTestType()
                            );
                        }
                    }
                }
        );

        attentionTest.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(attentionTest)) {
                            final TestSelectionState currentState = testSelectionViewModel.getState();

                            testSelectionController.execute(
                                    currentState.getUsername(),
                                    currentState.getTestDone(),
                                    currentState.getTestType()
                            );
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
//                            final LoginState currentState = loginViewModel.getState();
//
//                            loginController.execute(
//                                    currentState.getUsername(),
//                                    currentState.getPassword()
//                            );
                        }
                    }
                }
        );

        this.add(title);
        this.add(testErrorField);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void stateChanged() {
        testErrorField.setText(testSelectionViewModel.getState().getTestError());
    }

    public void setTestSelectionController(TestSelectionController loginController) {
        this.testSelectionController = loginController;
    }
}
