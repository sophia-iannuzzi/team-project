package interface_adapter.add_productivity;
import use_case.add_productivity.*;
import java.time.LocalDate;

public class AddProductivityController {
    private final AddProductivityInputBoundary myInteractor;

    public AddProductivityController(AddProductivityInputBoundary myInteractor){
        this.myInteractor = myInteractor;
    }

    // execute the code for the input screen
    public void execute(String username, String date, String rating) {
        AddProductivityInputData inputData = new AddProductivityInputData(username, date, rating);
        myInteractor.execute(inputData);
    }
}
