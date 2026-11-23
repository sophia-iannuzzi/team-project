package use_case.view_graph;

/**
 * OutputData of the use case interactor of the ViewGraph use case.
 */
public class ViewGraphOutputData {
    private String xAxis;
    private String yAxis;
    private Object[] xValues;
    private double[] yValues;

    ViewGraphOutputData(String xAxis, String yAxis, Object[] xValues, double[] yValues) {
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
    public Object[] getxValues() { return this.xValues; }
    public double[] getyValues() { return this.yValues; }
}
