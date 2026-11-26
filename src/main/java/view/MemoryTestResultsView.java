package view;

import interface_adapter.MemoryTest.MemoryTestController;
import interface_adapter.MemoryTest.MemoryTestState;
import interface_adapter.MemoryTest.MemoryTestViewModel;
import interface_adapter.MemoryTest.MemoryTestViewModelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * One of the view for the Memory Use Case.
 */

public class MemoryTestResultsView  extends JPanel implements ActionListener, MemoryTestViewModelListener {

    private final MemoryTestViewModel memoryTestViewModel;
    private MemoryTestController memoryTestController;

    private final JButton home;
    private final JLabel scoreLabel;
    private final JLabel correctWordsLabel;
    private final JLabel missedWordsLabel;

    public MemoryTestResultsView(MemoryTestViewModel memoryTestViewModel) {

        this.memoryTestViewModel = memoryTestViewModel;
        this.memoryTestViewModel.addListener(this);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        final JPanel buttons = new JPanel();

        JLabel title = new JLabel("Memory Test Results");
        title.setFont(new Font("Arial", Font.BOLD, 24));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        scoreLabel = new JLabel("Score: ");
        correctWordsLabel = new JLabel("Correct Words: ");
        missedWordsLabel = new JLabel("Missed Words: ");

        scoreLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        correctWordsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        missedWordsLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        home = new JButton("Return");
        buttons.add(home);

//        home.addActionListener(
//                new ActionListener() {
//                    public void actionPerformed(ActionEvent evt) {
//                        if (evt.getSource().equals(home)) {
//                            final MemoryTestState currentState = memoryTestViewModel.getState();
//
//                            memoryTestController.userReturnsToMenu(
//                                    currentState.getUsername()
//                            );
//                        }
//                    }
//                }
//        );

        add(title);
        add(Box.createVerticalStrut(30));
        add(scoreLabel);
        add(Box.createVerticalStrut(15));
        add(correctWordsLabel);
        add(Box.createVerticalStrut(15));
        add(missedWordsLabel);
//        add(Box.createVerticalStrut(30));
//        add(returnButton);
    }

    @Override
    public void stateChanged() {

        MemoryTestState state = memoryTestViewModel.getState();

        scoreLabel.setText(
                "Score: " + state.getScore()
                        + "/" + state.getTotalWords()
        );

        correctWordsLabel.setText(
                "Correct Words: " +
                        String.join(", ", state.getCorrectWords())
        );

        missedWordsLabel.setText(
                "Missed Words: " +
                        String.join(", ", state.getMissedWords())
        );
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
