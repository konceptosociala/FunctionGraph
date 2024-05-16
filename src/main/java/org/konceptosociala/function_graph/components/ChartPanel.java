package org.konceptosociala.function_graph.components;

import javax.swing.*;
import java.awt.*;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.konceptosociala.function_graph.FunctionGraphApp;

public class ChartPanel extends JPanel {
    public ChartPanel(FunctionGraphApp application, String author) {
        setLayout(new BorderLayout());
        setBorder(new PanelBorder("Graph", 5));

        XChartPanel<XYChart> xChartPanel = new XChartPanel<>(application.getChart());
        add(xChartPanel, BorderLayout.CENTER);

        application.rebuildChart();

        JPanel authorPanel = new JPanel();
        authorPanel.setBorder(new PanelBorder("Author", 0));
        authorPanel.add(new JLabel(author+" © 2024"));
        add(authorPanel, BorderLayout.SOUTH);
    }
}
