package org.konceptosociala.function_graph.components;

import javax.swing.*;
import java.awt.*;
import org.konceptosociala.function_graph.FunctionGraphApp;

public class SettingsPanel extends JPanel {
    public SettingsPanel(FunctionGraphApp application) {
        setBorder(new PanelBorder("Controls", 5));
        setLayout(new BorderLayout());

        Box box = Box.createVerticalBox();

        box.add(new ParamSpinner(
            application, 
            "Parameter a",
            "a", 
            new SpinnerNumberModel(
                application.getParams().get("a"), 
                null, 
                null, 
                0.01
            )
        ));

        box.add(new ParamSpinner(
            application, 
            "Parameter b", 
            "b", 
            new SpinnerNumberModel(
                application.getParams().get("b"), 
                null, 
                null, 
                0.01
            )
        ));

        box.add(new RangeSpinner(
            application, 
            "Min t",
            "Max t",
            "tMin", 
            "tMax", 
            new SpinnerNumberModel(
                application.getParams().get("tMin"), 
                null, 
                null, 
                0.1
            ), 
            new SpinnerNumberModel(
                application.getParams().get("tMax"), 
                null, 
                null, 
                0.1
            )
        ));

        box.add(new ParamSpinner(
            application, 
            "Step", 
            "step", 
            new SpinnerNumberModel(
                application.getParams().get("step").doubleValue(), 
                0.01, 
                10.0, 
                0.01
            )
        ));

        add(box, BorderLayout.NORTH);

        add(new SaveButton("Save image", application.getChart()), BorderLayout.SOUTH);
    }
}
