package view;

import interface_adapter.MemoryTest.MemoryTestController;
import interface_adapter.MemoryTest.MemoryTestState;
import interface_adapter.MemoryTest.MemoryTestViewModel;
import interface_adapter.MemoryTest.MemoryTestViewModelListener;

import javax.swing.*;
import java.awt.*;

/**
 * One of the view for the Memory Use Case.
 */

public class MemorizationView extends JPanel implements MemoryTestViewModelListener {

    private final JLabel wordsLabel;
    private final JLabel timerLabel;
    private final MemoryTestViewModel memoryTestViewModel;

    private MemoryTestController memoryTestController = null;

    private boolean testStarted = false;

    public MemorizationView(MemoryTestViewModel memoryTestViewModel) {
        this.memoryTestViewModel = memoryTestViewModel;
        this.memoryTestViewModel.addListener(this);

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Memorize These Words", SwingConstants.CENTER);

        title.setFont(new Font("Arial", Font.BOLD, 24));

        wordsLabel = new JLabel("", SwingConstants.CENTER);
        wordsLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        add(title, BorderLayout.NORTH);
        add(wordsLabel, BorderLayout.CENTER);

        timerLabel = new JLabel("Time remaining: ", SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.PLAIN, 18));

        this.add(timerLabel, BorderLayout.SOUTH);

    }

    public void startMemorizationTest() {
        if (!testStarted && memoryTestController != null) {
            testStarted = true;

            String username = memoryTestViewModel.getState().getUsername();
            memoryTestController.userStartsMemorizationTest(username);
        }
    }

    @Override
    public void stateChanged() {
        startMemorizationTest();

        MemoryTestState state = memoryTestViewModel.getState();

        StringBuilder words = new StringBuilder("<html><center>");

        for (String word : state.getSelectedWords()) {
            words.append(word).append("<br><br>");
        }

        words.append("</center></html>");

        wordsLabel.setText(words.toString());

        timerLabel.setText("Time remaining: " + state.getRemainingSeconds());

        revalidate();
        repaint();
    }

    public void setMemoryTestController(MemoryTestController memoryTestController) {
        this.memoryTestController = memoryTestController;
    }
}
