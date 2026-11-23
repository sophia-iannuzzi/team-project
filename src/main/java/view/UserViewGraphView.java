package view;
import interface_adapter.view_graph.ViewGraphController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewGraphView extends JPanel {

    private JLabel title = new JLabel("See my Productivity with:");
    private JButton moodButton = new JButton("Moods");
    private JButton scoreButton = new JButton("Scores");

    private JButton returnButton = new JButton("Return");
    private JPanel graphPanel = new JPanel();

    private ViewGraphController viewGraphController;

    public UserViewGraphView() {
        // set the overall layout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(moodButton);
        buttonPanel.add(scoreButton);

        // top panel
        JPanel topPanel = new JPanel();
        topPanel.add(title);
        topPanel.add(buttonPanel);

        // graph panel
        JLabel testLabel = new JLabel("GRAPH GOES HERE");
        graphPanel.add(testLabel);

        // bottom panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(returnButton);

        // add panels to overall UI
        this.add(topPanel);
        this.add(graphPanel);
        this.add(bottomPanel);

        // add listeners to buttons
        moodButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        testLabel.setText("Mood Bar Graph Here");

                        String typeChoice = "mood";
                        // temporary way of getting username. Should check with state to get.
                        // username is needed to get their data
                        String username = "TEMPORARY";


                        viewGraphController.execute(username, typeChoice);
                    }
                }
        );

        scoreButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testLabel.setText("Scores Line Graph Here");
                    }
                }
        );

        returnButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testLabel.setText("Return to home view");
                    }
                }
        );
    }

    // for testing & temporary viewing of view
    public static void main(String[] args) {
        UserViewGraphView u = new UserViewGraphView();

        JFrame frame = new JFrame();
        frame.setSize(400, 400);
        frame.setContentPane(u);
        frame.setVisible(true);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
