package interface_adapter.AttentionTest;

import ForTestingCognitiveTests.ViewManager.CognitiveTestViewManagerModel;
import use_case.AttentionTest.AttentionTestOutputBoundary;
import use_case.AttentionTest.AttentionTestOutputData;

/**
 * The Presenter for the Attention Test Use Case.
 */

public class AttentionTestPresenter implements AttentionTestOutputBoundary {

    private final AttentionTestViewModel attentionTestViewModel;
    private final CognitiveTestViewManagerModel viewManagerModel;

    public AttentionTestPresenter(AttentionTestViewModel attentionTestViewModel, CognitiveTestViewManagerModel viewManagerModel) {
        this.attentionTestViewModel = attentionTestViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(AttentionTestOutputData outputData) {

    }

}
