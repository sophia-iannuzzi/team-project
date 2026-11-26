package ForTestingCognitiveTests;

import javax.swing.*;

public class CognitiveTestTesting {
    public static void main(String[] args) {
        TestAppBuilder appBuilder = new TestAppBuilder();
        JFrame application = appBuilder
                .addMemoryTestView()
                .addMemoryTestUseCase()
                .addAttentionTestView()
                .addTestSelectionView()
                .addTestSelectionUseCase()
                .build();

        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}