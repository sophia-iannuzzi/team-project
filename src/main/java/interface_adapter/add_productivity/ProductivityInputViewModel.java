package interface_adapter.add_productivity;
import java.util.*;

public class ProductivityInputViewModel {
    public static final String VIEW_NAME = "add productivity";
    private final List<ProductivityInputViewModelListener> listeners = new ArrayList<>();
    private AddProductivityState productivityState = new AddProductivityState();

    // Getters and Setters
    public AddProductivityState getState() { return this.productivityState;}
    public void setProductivityState(AddProductivityState state){this.productivityState = state;}
    public String getViewName() {return VIEW_NAME;}

    public void addListener(ProductivityInputViewModelListener listener){this.listeners.add(listener);}

    /**
     * Record that the view state has changed
     */
    public void notifyStateChanged() {
        for(int i = 0; i < listeners.size(); i +=1){
            listeners.get(i).stateChanged();
        }
    }
}
