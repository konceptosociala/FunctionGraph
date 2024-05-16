package org.konceptosociala.function_graph.components;

import javax.swing.*;

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SaveButton extends JButton {
    public SaveButton(String label, XYChart chart) {
        setText(label);
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int retrival = chooser.showSaveDialog(null);
                if (retrival == JFileChooser.APPROVE_OPTION) {
                    try {
                        BitmapEncoder.saveBitmap(chart, chooser.getSelectedFile().getAbsolutePath()+".png", BitmapFormat.PNG);
                        JOptionPane.showMessageDialog(null, "Image successfully saved!", "Success", JOptionPane.INFORMATION_MESSAGE); 
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }
}
