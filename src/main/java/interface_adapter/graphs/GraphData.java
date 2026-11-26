package interface_adapter.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphData {
    public enum GraphType{
        BAR, LINE
    }
    private final GraphType type;
    private final String title;
    private final String xAxisTitle;
    private final String yAxisTitle;
    private final List<Double> xValuesLine;
    private final List<String> xValuesBar;
    private final List<Double> yValuesLine;

    public GraphData(GraphType type, String title, String xAxisTitle, String yAxisTitle, List<Double> xValuesLine,
                     List<String> xValuesBar, List<Double> yValuesLine){
        this.type = type;
        this.title = title;
        this.xAxisTitle = xAxisTitle;
        this.yAxisTitle = yAxisTitle;
        this.xValuesLine = xValuesLine;
        this.xValuesBar = xValuesBar;
        this.yValuesLine = yValuesLine;
    }
    public GraphType getType() {
        return type;
    }
    public String getTitle() {
        return title;
    }

    public String getxAxisTitle() {
        return xAxisTitle;
    }

    public String getyAxisTitle() {
        return yAxisTitle;
    }

    public List<Double> getxValuesLine() {
        return xValuesLine;
    }

    public List<String> getxValuesBar() {
        return xValuesBar;
    }

    public List<Double> getyValuesLine() {
        return yValuesLine;
    }


}
