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
                4.23, 
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
                2.35, 
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
                -15.0, 
                null, 
                null, 
                0.1
            ), 
            new SpinnerNumberModel(
                20.0, 
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
                0.1, 
                0.01, 
                10, 
                0.01
            )
        ));

        add(box, BorderLayout.NORTH);

        add(new SaveButton("Save image", application.getChart()), BorderLayout.SOUTH);
    }
}
