package view;

import interface_adapter.MemoryTest.MemoryTestController;
import interface_adapter.MemoryTest.MemoryTestState;
import interface_adapter.MemoryTest.MemoryTestViewModel;
import interface_adapter.MemoryTest.MemoryTestViewModelListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * One of the view for the Memory Use Case.
 */

public class AnsweringView  extends JPanel implements ActionListener, MemoryTestViewModelListener {

    private final MemoryTestViewModel memoryTestViewModel;

    private final JTextField answerInputField = new JTextField(15);
    private final DefaultListModel<String> answerListModel = new DefaultListModel<>();

    private final JButton submit;
    private final JButton finish;

    private MemoryTestController memoryTestController = null;

    public AnsweringView(MemoryTestViewModel memoryTestViewModel) {
        this.memoryTestViewModel = memoryTestViewModel;
        this.memoryTestViewModel.addListener(this);

        final JLabel title = new JLabel("Enter the Words You Remember");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel answerInfo = new JPanel();
        answerInfo.add(new JLabel("Your Answer"));
        answerInfo.add(answerInputField);

        final JList<String> answerList = new JList<>(answerListModel);
        final JScrollPane scrollPane = new JScrollPane(answerList);
        scrollPane.setPreferredSize(new Dimension(300, 150));

        final JPanel buttons = new JPanel();

        submit = new JButton("Submit");
        buttons.add(submit);

        finish = new JButton("Finish");
        buttons.add(finish);

        submit.addActionListener(this);
        finish.addActionListener(this);

        answerInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final MemoryTestState currentState = memoryTestViewModel.getState();
                currentState.setAnswerInput(answerInputField.getText());
                memoryTestViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(Box.createVerticalStrut(20));
        this.add(answerInfo);
        this.add(Box.createVerticalStrut(10));
        this.add(buttons);
        this.add(Box.createVerticalStrut(20));
        this.add(new JLabel("Your Submitted Answers:"));
        this.add(scrollPane);
    }

    public void setMemoryTestController(MemoryTestController memoryTestController) {
        this.memoryTestController = memoryTestController;
    }

    @Override
    public void stateChanged() {
        MemoryTestState state = memoryTestViewModel.getState();

        answerListModel.clear();

        for (String answer : state.getSubmittedAnswers()) {
            answerListModel.addElement(answer);
        }
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getSource().equals(submit)) {
            final MemoryTestState currentState = memoryTestViewModel.getState();

            memoryTestController.userSubmitsAnswers(
                    currentState.getAnswerInput().trim()
            );

            answerInputField.setText("");
        }

        else if (evt.getSource().equals(finish)) {
            memoryTestController.userFinishesTest();
        }
    }
}
