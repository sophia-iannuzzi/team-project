package interface_adapter.researcher_data_fetch;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;
import use_case.resercher_data_fetch.ResearcherDataFetchInputBoundary;
import use_case.resercher_data_fetch.ResearcherFetchDataInputData;

import java.util.Date;

public class ResearcherDataFetchController {
    private final ResearcherDataFetchInputBoundary UseCaseInteractor;

    public ResearcherDataFetchController(ResearcherDataFetchInputBoundary UseCaseInteractor) {
        this.UseCaseInteractor = UseCaseInteractor;
    }

    public void execute(Date start, Date finish, String testType) {
        final ResearcherFetchDataInputData inputData = new ResearcherFetchDataInputData(
                start, finish,testType);

        UseCaseInteractor.execute(inputData);
    }

    public void fetchAll(Date start, Date finish, String testType){
        ResearcherFetchDataInputData inputData = new ResearcherFetchDataInputData(start,finish,testType);
        UseCaseInteractor.execute(inputData);

    }
}
