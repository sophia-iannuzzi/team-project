package view.add_productivity_views;
import interface_adapter.add_productivity.AddProductivityState;
import interface_adapter.add_productivity.ProductivityInputViewModel;
import interface_adapter.add_productivity.ProductivityInputViewModelListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.*;


public class ProductivityInputView extends JPanel implements ActionListener{
    private final ProductivityInputViewModel viewModel;

    // The input fields for the rating
    private final JTextField dateInput = new JTextField(10);
    private final JTextField ratingInput = new JTextField(4);

    // The Buttons to submit or cancel
    private final JButton submit;
    private final JButton cancel;

    // For any error
    private final JLabel dateError = new JLabel();


    public ProductivityInputView(ProductivityInputViewModel viewModel){
        this.viewModel = viewModel;

        // Title and instructions as usual
        final JLabel title = new JLabel("Add Your Productivity Rating");

        final JLabel date_instructions = new JLabel("Please enter in the format of DD/MM/YYYY (e.g. 01/02/2026 for " +
                "February 1st, 2026)");
        final JLabel rating_instructions = new JLabel("Please enter your productivity rating as a number between 1 " +
                "and 10 (e.g. 5.4)");

        // Getting the date
        final JPanel dateInfo = new JPanel();
        dateInfo.add(new JLabel("Date (DD/MM/YYYY): "));
        dateInfo.add(this.dateInput);

        // Getting the productivity
        final JPanel ratingInfo = new JPanel();
        ratingInfo.add(new JLabel("Rating: "));
        ratingInfo.add(this.ratingInput);

        // Buttons
        final JPanel buttons = new JPanel();
        this.submit = new JButton("Submit");
        this.cancel = new JButton("Cancel");
        buttons.add(this.submit);
        buttons.add(this.cancel);

        // Button listeners
        this.submit.addActionListener(this);
        this.cancel.addActionListener(this);

        // Error messages
        dateError.setForeground(Color.RED);

        // Add components to the screen
        this.add(title);
        this.add(date_instructions);
        this.add(rating_instructions);
        this.add(dateError);
        this.add(buttons);
        this.add(ratingInfo);
        this.add(dateInfo);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource().equals(this.submit)){
            // Get the date and rating entered by the user
            String addedDate = dateInput.getText();
            String addedRating = ratingInput.getText();

            // Get the username from the state
            AddProductivityState state = this.viewModel.getState();
            String username = state.getUsername();

            // TODO: Send the username date and rating to the controller to be used as input values
        } else if (e.getSource().equals(this.cancel)){
            //TODO: Send them back to the home view
        }
    }

}
