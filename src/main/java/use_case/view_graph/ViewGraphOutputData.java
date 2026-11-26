package use_case.view_graph;

import java.util.List;

/**
 * OutputData of the use case interactor of the ViewGraph use case.
 */
public class ViewGraphOutputData {
    private String type;
    private String xAxis;
    private String yAxis;
    private List<Object> xValues;
    private List<Double> yValues;

    ViewGraphOutputData(String type, String xAxis, String yAxis, List<Object> xValues, List<Double> yValues) {
        this.type = type;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.xValues = xValues;
        this.yValues = yValues;
    }

    /**
     * Retrieve the axis labels
     * @return the corresponding axis label
     */
    public String getxAxis() { return xAxis; }
    public String getyAxis() { return yAxis; }

    /**
     * Retrieve the axis coordinates.
     * @return the corresponding axis coordinates.
     */
    public List<Object> getxValues() { return this.xValues; }
    public List<Double> getyValues() { return this.yValues; }

    public String getType() { return this.type; }
}
