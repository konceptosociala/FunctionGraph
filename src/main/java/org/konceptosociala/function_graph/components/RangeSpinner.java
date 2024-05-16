package org.konceptosociala.function_graph.components;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import org.konceptosociala.function_graph.FunctionGraphApp;

public class RangeSpinner extends JPanel {
    public RangeSpinner(
        FunctionGraphApp application,
        String labelFrom,
        String labelTo,
        String paramNameFrom,
        String paramNameTo,
        SpinnerNumberModel modelFrom,
        SpinnerNumberModel modelTo
    ){
        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(new JLabel(labelFrom));
        JSpinner spinnerFrom = new JSpinner();
        spinnerFrom.setModel(modelFrom);
        spinnerFrom.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                application.getParams().replace(paramNameFrom, (double)spinnerFrom.getValue());
                application.rebuildChart();
            }
        });
        add(spinnerFrom);

        add(new JLabel(labelTo));
        JSpinner spinnerTo = new JSpinner();
        spinnerTo.setModel(modelTo);
        spinnerTo.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                application.getParams().replace(paramNameTo, (double)spinnerTo.getValue());
                application.rebuildChart();
            }
        });
        add(spinnerTo);
    }
}
