package ForTestingCognitiveTests.ViewManager;

import javax.swing.*;
import java.awt.*;

public class CognitiveTestViewManager implements CognitiveTestViewManagerModelListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private final CognitiveTestViewManagerModel viewManagerModel;

    public CognitiveTestViewManager(JPanel views, CardLayout cardLayout,
                                    CognitiveTestViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addListener(this);
    }


    @Override
    public void viewChanged() {
        cardLayout.show(views, viewManagerModel.getCurrentViewName());
    }
}
