package view;

import com.sun.jdi.Value;
import interface_adapter.graphs.GraphData;

import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import jdk.jfr.Category;

import java.util.List;

import static interface_adapter.graphs.GraphData.GraphType.BAR;

public class GraphGenerator {
    JFXPanel panel = new JFXPanel();
    public JFXPanel generateGraph(GraphData data) throws IllegalAccessException {
        if(data == null){
            throw new IllegalAccessException("Graph data cannot be null");
        }
        switch(data.getType()){ //takes graph type as cases in order to determine what method to use
            case BAR:
                return createBarGraph(data);
            case LINE:
                return  createLineGraph(data);
            default:
                throw new IllegalAccessException("Graph type not supported");
        }
    }

    //creates line graph
    public JFXPanel createLineGraph(GraphData data){
        NumberAxis x = new NumberAxis();
        NumberAxis y = new NumberAxis();
        //stores titles of axis
        x.setLabel(data.getxAxisTitle());
        y.setLabel(data.getyAxisTitle());

        //creates chart
        LineChart<Number, Number> chart = new LineChart<>(x,y);

        //sets title of the chart
        chart.setTitle(data.getTitle());
        List<Double> xVal = data.getxValuesLine();
        List<Double> yVal = data.getyValuesLine();

        //series to store the data
        XYChart.Series<Number, Number> series= new XYChart.Series<>();

        for(int i = 0; i<xVal.size();i++){
            series.getData().add(new XYChart.Data<>(xVal.get(i),yVal.get(i)));
        }

        chart.getData().add(series);
        Scene scene = new Scene(chart);
        panel.setScene(scene);
        return panel;

    }

    //does the same as createLinegraph but does it for bar chart
    public JFXPanel createBarGraph(GraphData data){
        CategoryAxis x = new CategoryAxis();
        NumberAxis y = new NumberAxis();
        x.setLabel(data.getxAxisTitle());
        y.setLabel(data.getyAxisTitle());

        BarChart<String, Number> chart1 = new BarChart<>(x,y);


        chart1.setTitle(data.getTitle());
        List<String> xVal = data.getxValuesBar();
        List<Double> yVal = data.getyValuesLine();

        XYChart.Series<String, Number> series1= new XYChart.Series<>();

        for(int i = 0; i<xVal.size();i++){
            series1.getData().add(new XYChart.Data<String, Number>(xVal.get(i),yVal.get(i)));
        }

        chart1.getData().add(series1);
        Scene scene1 = new Scene(chart1);
        panel.setScene(scene1);

        return panel;

    }
}
