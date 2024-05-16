package org.konceptosociala.function_graph.utils;

import static java.lang.Math.*;

import java.util.ArrayList;
import java.awt.*;

import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class FunctionGraph extends XYChart {

    public FunctionGraph(Color bgColor) {
        super(0, 0);
        getStyler().setChartBackgroundColor(bgColor);
        getStyler().setLegendVisible(false);
        getStyler().setChartTitleVisible(false);
        getStyler().setAxisTitlesVisible(false);

        XYSeries series = addSeries("graph", new double[1], new double[1]);
        series.setMarker(SeriesMarkers.NONE);
    }

    public void rebuild(Params params) {
        var xData = new ArrayList<Double>();
        var yData = new ArrayList<Double>();

        var a = params.get("a");
        var b = params.get("b");
        var tMin = params.get("tMin");
        var tMax = params.get("tMax");
        var step = params.get("step");
        
        for (double t = tMin; t < tMax; t += step) {
            double x = (a + b) * cos(t) - b * cos((a / b + 1) * t);
            double y = (a + b) * sin(t) - b * sin((a / b + 1) * t);

            xData.add(x);
            yData.add(y);
        }

        updateXYSeries("graph", xData, yData, null);
    }
    
}
