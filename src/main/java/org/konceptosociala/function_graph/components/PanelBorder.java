package org.konceptosociala.function_graph.components;

import javax.swing.*;
import javax.swing.border.*;

public class PanelBorder extends CompoundBorder {
    public PanelBorder(String title, int padding) {
        super(
            BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), 
                title
            ),
            BorderFactory.createEmptyBorder(padding, padding, padding, padding)
        );
    }
}
