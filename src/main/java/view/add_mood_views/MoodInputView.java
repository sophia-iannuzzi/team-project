package view.add_mood_views;
import interface_adapter.add_mood.AddMoodState;
import interface_adapter.add_mood.MoodInputViewModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.*;


public class MoodInputView extends JPanel implements ActionListener{

    private final MoodInputViewModel viewModel;

    // They will be inputting their mood from a dropdown menu, so no need for an error message part!!
    private final JComboBox<String> moodOptions;
    private final JButton submit;
    private final JButton cancel;
    private final String[] moods = { "Happy", "Sad", "Angry", "Anxious", "Calm", "Tired", "Excited"};   // for selection

    public MoodInputView (MoodInputViewModel moodInputViewModel){
        this.viewModel = moodInputViewModel;

        // Title and Insrtuctions
        JLabel title = new JLabel("Mood Selection Page");
        JLabel instructions = new JLabel("Please select the mood that best describes your overall mood");

        // Mood options in the drop down menu
        this.moodOptions = new JComboBox<>(moods);

        // Buttons
        final JPanel buttons = new JPanel();

        this.submit = new JButton("Submit");
        this.cancel = new JButton("Cancel");

        buttons.add(this.submit);
        buttons.add(this.cancel);

        // Button listeners
        this.submit.addActionListener(this);
        this.cancel.addActionListener(this);

        // Add the components to the screen
        this.add(title);
        this.add(instructions);
        this.add(moodOptions);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(submit)) {

            // Retrieve the user's selected mood
            String selectedMood =
                    (String) moodOptions.getSelectedItem();

            // Retrieve the username and date from the state
            AddMoodState currentState = viewModel.getState();

            String username = currentState.getUsername();
            LocalDate date = currentState.getDate();

            // TODO: Pass username, date, and selectedMood to the AddMoodController. RAAHHHHHHHHHHHHHH
        }
        else if (e.getSource().equals(cancel)) {
            // TODO: Connect back to the home view. There are so many classes oh my actual god
        }
    }
}
