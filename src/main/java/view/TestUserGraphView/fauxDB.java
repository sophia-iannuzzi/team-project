package view.TestUserGraphView;

import entities.CognitiveData;
import use_case.view_graph.ViewGraphDataAccessInterface;

import java.util.Date;

public class fauxDB implements ViewGraphDataAccessInterface {
    public CognitiveData[] getData(String username) {
        CognitiveData cog1 = new CognitiveData.CogBuilder(new Date(0))
                .mood("happy")
                .productivityRating(10.0)
                .cogTest("mental", 10.0)
                .build();

        CognitiveData cog2 = new CognitiveData.CogBuilder(new Date(0))
                .mood("sad")
                .productivityRating(9.0)
                .cogTest("mental", 9.0)
                .build();

        CognitiveData[] done = {cog1, cog2};
        return done;

    }
}
