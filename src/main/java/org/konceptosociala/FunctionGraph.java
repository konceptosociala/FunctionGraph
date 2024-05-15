package org.konceptosociala;

import static java.lang.Math.*;

import java.util.ArrayList;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;
import org.knowm.xchart.*;

public class FunctionGraph extends JFrame {
    Params params;
    XYChart chart;

    FunctionGraph() {
        params = new Params();
        chart = new XYChart(0, 0);

        initApp();
        add(controlPanel(), BorderLayout.EAST);
        add(chartPanel(), BorderLayout.CENTER);
    }

    private void initApp() {
        FlatLightOwlIJTheme.setup();
        setTitle("Function graph №6");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private JPanel chartPanel() {
        JPanel chartPanel = new JPanel(new BorderLayout());
        chartPanel.setBorder(panelBorder(5, "Graph"));

        generateChart();
        chart.getStyler().setChartBackgroundColor(Color.decode("#F0F0F0"));

        XChartPanel<XYChart> xChartPanel = new XChartPanel<>(chart);
        chartPanel.add(xChartPanel, BorderLayout.CENTER);

        JPanel author = new JPanel();
        author.setBorder(panelBorder(5, "Author"));
        author.add(new JLabel("Oleksandr Hnutov"));
        chartPanel.add(author, BorderLayout.SOUTH);

        return chartPanel;
    }

    private JPanel controlPanel() {
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        
        JPanel formula = new JPanel();
        formula.setBorder(panelBorder(5, "Formula"));
        formula.setLayout(new BoxLayout(formula, BoxLayout.Y_AXIS));
        formula.add(new JLabel("x = (a + b) * cos(t) – b * cos((a / b + 1) * t)"));
        formula.add(new JLabel("y = (a + b) * sin(t) – b * sin((a / b + 1) * t)"));
        controlPanel.add(formula, BorderLayout.NORTH);

        JPanel controls = new JPanel();
        controls.setBorder(panelBorder(5, "Controls"));
        controls.setPreferredSize(getPreferredSize());
        controlPanel.add(controls, BorderLayout.CENTER);

        return controlPanel;
    }

    private Border panelBorder(int padding, String title) {
        return BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), 
                title
            ), 
            BorderFactory.createEmptyBorder(padding, padding, padding, padding)
        );
    }

    private void generateChart() {
        var xData = new ArrayList<Double>();
        var yData = new ArrayList<Double>();

        for (double t = params.tMin; t < params.tMax; t += params.step) {
            double x = (params.a + params.b) * cos(t) - params.b * cos((params.a / params.b + 1) * t);
            double y = (params.a + params.b) * sin(t) - params.b * sin((params.a / params.b + 1) * t);

            xData.add(x);
            yData.add(y);
        }

        chart = QuickChart.getChart("", "", "", "y", xData, yData);
    }

    public static void main(String[] args) {
        FunctionGraph app = new FunctionGraph();
        app.setVisible(true);
    }

    class Params {
        double a = 4.23;
        double b = 2.35;
        double tMin = -15;
        double tMax = 20;
        double step = 0.1;
    }
}
