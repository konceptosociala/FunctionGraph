package org.konceptosociala.function_graph.components;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import org.konceptosociala.function_graph.FunctionGraphApp;

public class ParamSpinner extends JPanel {
    public ParamSpinner(
        FunctionGraphApp application,
        String label, 
        String paramName,
        SpinnerNumberModel model
    ){
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(new JLabel(label));

        JSpinner spinner = new JSpinner();
        spinner.setModel(model);
        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                application.getParams().replace(paramName, (double)spinner.getValue());
                application.rebuildChart();
            }
        });

        add(spinner);
    }
}
