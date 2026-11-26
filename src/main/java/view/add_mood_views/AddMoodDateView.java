package view.add_mood_views;
import interface_adapter.add_mood.*;
import view.LabelTextPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class AddMoodDateView extends JPanel implements ActionListener {
    private final MoodInputViewModel viewModel;
    private final JLabel dateError = new JLabel();
    private AddMoodController moodController;// The only change that might occur here is that they will go to addView
    private final JTextField dateInputField = new JTextField(10);
    private final JButton addDate;
    private final JButton cancel;


    public AddMoodDateView(MoodInputViewModel viewModel, AddMoodController controller){
        this.viewModel = viewModel;
        this.moodController = controller;

        // Create the text at the top of the add mood screen + instructions for how to add the date
        final JLabel title = new JLabel("Add Date For New Mood Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JLabel instructions = new JLabel(
                "Please enter in the format of DD/MM/YYYY (e.g. 01/02/2026 for February 1st, 2026)"
        );
        instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

        // The date input part
        final LabelTextPanel dateInfo = new LabelTextPanel(
                new JLabel("Date (DD/MM/YYYY): "), dateInputField);

        // Buttons to submit their part or to return to the home screen
        final JPanel buttons = new JPanel();
        addDate = new JButton("continue");
        buttons.add(addDate);
        cancel = new JButton("cancel");
        buttons.add(cancel);

        // Error messages
        dateError.setForeground(Color.RED);

        // Add my components to the screen
        this.add(title);
        this.add(instructions);
        this.add(dateInfo);
        this.add(buttons);
        this.add(dateError);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(addDate)){
            final AddMoodState state = this.viewModel.getState();
            moodController.execute(state.getUsername(), dateInputField.getText());
        } else if (e.getSource().equals(cancel)){
            //TODO: Connect back to the home view
        }
    }
}
