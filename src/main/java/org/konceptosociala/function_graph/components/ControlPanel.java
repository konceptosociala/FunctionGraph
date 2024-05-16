package org.konceptosociala.function_graph.components;

import javax.swing.*;
import java.awt.*;
import org.konceptosociala.function_graph.FunctionGraphApp;

public class ControlPanel extends JPanel {
    public ControlPanel(FunctionGraphApp application) {
        setLayout(new BorderLayout());
        
        add(
            new FormulaPanel(new String[]{
                "x = (a + b) * cos(t) – b * cos((a / b + 1) * t)",
                "y = (a + b) * sin(t) – b * sin((a / b + 1) * t)"
            }), 
            BorderLayout.NORTH
        );

        add(new SettingsPanel(application), BorderLayout.CENTER);
    }
}
