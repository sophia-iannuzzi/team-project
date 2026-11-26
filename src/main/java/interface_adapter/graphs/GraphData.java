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

    public GraphData(GraphDataBuilder b){
        this.type = b.type;
        this.title = b.title;
        this.xAxisTitle = b.xAxisTitle;
        this.yAxisTitle = b.yAxisTitle;
        this.xValuesLine = b.xValuesLine;
        this.xValuesBar = b.xValuesBar;
        this.yValuesLine = b.yValuesLine;
    }

    public static class GraphDataBuilder {
        public GraphType type;
        public String title;
        public String xAxisTitle;
        public String yAxisTitle;
        public List<Double> xValuesLine;
        public List<String> xValuesBar;
        public List<Double> yValuesLine;

        public GraphDataBuilder(GraphType type) {
            this.type = type;
        }

        public GraphDataBuilder title(String title) {
            this.title = title;
            return this;
        }
        public GraphDataBuilder xAxisTitle(String title) {
            this.xAxisTitle = title;
            return this;
        }
        public GraphDataBuilder yAxisTitle(String title) {
            this.yAxisTitle = title;
            return this;
        }
        public GraphDataBuilder xValuesLine(List<Double> xValuesLine) {
            this.xValuesLine = xValuesLine;
            return this;
        }
        public GraphDataBuilder xValuesBar(List<String> xValuesBar) {
            this.xValuesBar = xValuesBar;
            return this;
        }
        public GraphDataBuilder yValuesLine(List<Double> yValuesLine) {
            this.yValuesLine = yValuesLine;
            return this;
        }
        public GraphData build() {
            return new GraphData(this);
        }


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
