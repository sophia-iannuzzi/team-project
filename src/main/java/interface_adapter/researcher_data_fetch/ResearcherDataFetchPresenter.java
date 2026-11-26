package interface_adapter.researcher_data_fetch;

import entities.CognitiveData;
import use_case.resercher_data_fetch.ResearcherDataFetchOutputBoundary;
import use_case.resercher_data_fetch.ResearcherDataFetchOutputData;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ResearcherDataFetchPresenter implements ResearcherDataFetchOutputBoundary {
    private final ResearcherDataFetchViewModel viewModel;

    public ResearcherDataFetchPresenter(
            ResearcherDataFetchViewModel viewModel) {

        this.viewModel = viewModel;
    }

    @Override
    public void prepareSuccessView(
            ResearcherDataFetchOutputData outputData) {

        List<CognitiveDataTable> table = new ArrayList<>();

        for (CognitiveData data : outputData.getRecord()) {

            CognitiveDataTable row = new CognitiveDataTable(
                    data.getDate(),
                    data.getProductivityRating(),
                    ((Number) data.getCognitiveTest()[1]).doubleValue(),
                    data.getMood(),
                    (String) data.getCognitiveTest()[0]
            );

            table.add(row);
        }

        ResearcherDataFetchState state = viewModel.getState();

        state.setTable(table);
        state.setError(null);

        viewModel.setState(state);
        viewModel.notifyStateChanged();
    }

    @Override
    public void prepareFailView(String error) {

        ResearcherDataFetchState state = viewModel.getState();

        state.setError(error);

        viewModel.setState(state);
        viewModel.notifyStateChanged();
    }


}
