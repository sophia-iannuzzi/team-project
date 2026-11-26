package interface_adapter.view_graph;

import java.util.List;

public class ViewGraphState {
    private Boolean needGraph = false;
    private String xTitle = "";
    private String yTitle = "";
    private String title = "";

    private List<Object>  xValues;
    private List<Double>  yValues;

    private String type;

    public void setNeedGraph() { this.needGraph = true; }

    public void setxTitle(String title) { this.xTitle = title; }
    public String getxTitle() { return this.xTitle; }

    public void setyTitle(String title) { this.yTitle = title; }
    public String getyTitle() { return this.yTitle; }

    public void setTitle(String title) { this.title = title; }
    public String getTitle() { return this.title; }


    public void setxValues(List<Object> values) { this.xValues = values; }
    public List<Object> getxValues() { return this.xValues; }

    public void setyValues(List<Double> values) { this.yValues = values; }
    public List<Double> getyValues() { return this.yValues; }

    public void setType(String type) { this.type = type; }
    public String getType() { return this.type; }

    public Boolean needGraph() { return this.needGraph; }

}
