package org.konceptosociala.function_graph.components;

import javax.swing.*;

public class FormulaPanel extends JPanel {
    public FormulaPanel(String[] formulas) {
        setBorder(new PanelBorder("Formula", 5));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (String formula : formulas) {
            add(new JLabel(formula));
        }
    }
}
