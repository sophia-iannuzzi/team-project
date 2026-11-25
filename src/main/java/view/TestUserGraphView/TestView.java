package view.TestUserGraphView;

import view.UserViewGraphView;

import javax.swing.*;

public class TestView {
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
