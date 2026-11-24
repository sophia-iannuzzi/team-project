package ForTestingPurposes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AppBuilder appBuilder = new AppBuilder();
        JFrame application = appBuilder
                .addMemoryTestView()
                .addAttentionTestView()
                .addTestSelectionView()
                .addTestSelectionUseCase()
                .build();

        application.pack();
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}