package view;
import interface_adapter.graphs.GraphData;
import interface_adapter.view_graph.*;
import javafx.embed.swing.JFXPanel;


import javax.swing.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserViewGraphView extends JPanel implements ActionListener, ViewGraphModelListener {

    private JLabel title;
    private JButton moodButton;
    private JButton scoreButton;

    private JButton returnButton;
    private JPanel graphPanel = new JPanel();

    private JFrame graphFrame = new JFrame();

    private ViewGraphController viewGraphController;
    private ViewGraphViewModel viewGraphViewModel;

    JLabel testLabel = new JLabel("to test");

    public UserViewGraphView(ViewGraphViewModel viewGraphViewModel, ViewGraphController viewGraphController) {
        this.viewGraphViewModel = viewGraphViewModel;
        this.viewGraphController = viewGraphController;


        // set button texts
        title = new JLabel(viewGraphViewModel.TITLE);
        moodButton = new JButton(viewGraphViewModel.MOOD_LABEL);
        scoreButton = new JButton(viewGraphViewModel.SCORE_LABEL);
        returnButton = new JButton(viewGraphViewModel.RETURN);


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
        testLabel = new JLabel("Graph Status here");
        graphPanel.add(testLabel);
        graphFrame.setSize(400, 400);

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

                        String typeChoice = "score";
                        // temporary way of getting username. Should check with state to get.
                        // username is needed to get their data
                        String username = "TEMPORARY";


                        viewGraphController.execute(username, typeChoice);
                    }
                }
        );

        returnButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        testLabel.setText("Return to home view");

                        // remove graphFrame
                    }
                }
        );
    }

    /**
     * The View Graph state was updated.
     */
    public void stateChanged() {
        ViewGraphState state = viewGraphViewModel.getState();
        if (state.needGraph()) {
            // call to graph maker
            this.testLabel.setText("success");
            graphFrame.setVisible(false);

            GraphGenerator GraphMaker = new GraphGenerator();

            switch(viewGraphViewModel.getState().getType()) {
                case "bar" :
                    GraphData dataBar = new GraphData.GraphDataBuilder(GraphData.GraphType.BAR)
                            .title(state.getTitle())
                            .xAxisTitle(state.getxTitle())
                            .yAxisTitle(state.getyTitle())
                            .yValuesLine(state.getyValues())
                            .xValuesBar((List<String>)(Object)state.getxValues())
                            .build();

                    // construct graph
                    try {
                        JFXPanel graphBar = GraphMaker.generateGraph(dataBar);
                        // show in frame
                        graphFrame.setContentPane(graphBar);
                        graphFrame.validate();
                        graphFrame.setVisible(true);
                    } catch (IllegalAccessException e) {
                        testLabel.setText(e.getMessage());
                    }

                case "line" :
                    GraphData dataLine = new GraphData.GraphDataBuilder(GraphData.GraphType.LINE)
                            .title(state.getTitle())
                            .xAxisTitle(state.getxTitle())
                            .yAxisTitle(state.getyTitle())
                            .yValuesLine(state.getyValues())
                            .xValuesLine((List<Double>)(Object)state.getxValues())
                            .build();

                    // construct graph
                    try {
                        JFXPanel graphLine = GraphMaker.generateGraph(dataLine);
                        // show in frame
                        graphFrame.setContentPane(graphLine);
                        graphFrame.validate();
                        graphFrame.setVisible(true);
                    } catch (IllegalAccessException e) {
                        testLabel.setText(e.getMessage());
                    }
            }
        }
    };

    public void actionPerformed(ActionEvent evt){};
}
