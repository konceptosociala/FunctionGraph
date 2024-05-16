package org.konceptosociala.function_graph;

import java.awt.*;
import javax.swing.*;
import lombok.*;
import com.formdev.flatlaf.intellijthemes.*;
import org.konceptosociala.function_graph.components.*;
import org.konceptosociala.function_graph.utils.*;

public class FunctionGraphApp extends JFrame {
    @Getter
    Params params = new Params();
    @Getter
    FunctionGraph chart = new FunctionGraph(Color.decode("#F5F5F5"));

    public FunctionGraphApp() {
        initApp();
        add(new ControlPanel(this), BorderLayout.EAST);
        add(new ChartPanel(this, "Oleksandr Hnutov"), BorderLayout.CENTER);
    }

    private void initApp() {
        FlatArcOrangeIJTheme.setup();
        setTitle("Function graph №6");
        setSize(800, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void rebuildChart() {
        chart.rebuild(params);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        FunctionGraphApp app = new FunctionGraphApp();
        app.setVisible(true);
    }
}
