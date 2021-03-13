package com.github.libkhadir.ui;

import javax.swing.*;
import java.awt.*;

public class MassUploadFrame extends JFrame {
    private String[][] data;
    private static final String[] headers = {"lat1", "lon1", "lat2", "lon2", "distance (km)"};

    public MassUploadFrame(final String[][] data) {
        this.data = data;
        setSize(600, 500);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initResultTable();
    }

    private void initResultTable() {
        JTable resultTable = new JTable(data, headers);
        resultTable.setEnabled(false);
        getContentPane().add(new JScrollPane(resultTable), BorderLayout.CENTER);
    }
}
