package com.github.libkhadir.ui;

import com.github.libkhadir.actions.CalculateAction;
import com.github.libkhadir.actions.EditAction;
import com.github.libkhadir.utils.TranslationHelper;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {

    private EditAction originLatitudeActionListener;
    private EditAction originLongitudeActionListener;
    private EditAction destinationLatitudeActionListener;
    private EditAction destinationLongitudeActionListener;

    public CalculatorFrame() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));
        mainPanel.add(initOriginPanel());
        mainPanel.add(initDestinationPanel());
        mainPanel.add(initResultPanel());
        this.add(mainPanel);
        setTitle(TranslationHelper.getMessage("app.title"));
        setSize(500, 500);
        setResizable(true);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private JPanel initOriginPanel() {
        JPanel originPanel = new JPanel();
        originPanel.setLayout(new GridLayout(2, 1));
        JTextField originLatitudeField = new JTextField();
        originLatitudeActionListener = new EditAction(originLatitudeField);
        originLatitudeField.getDocument().addDocumentListener(originLatitudeActionListener);
        JTextField originLongitudeField = new JTextField();
        originLongitudeActionListener = new EditAction(originLongitudeField);
        originLongitudeField.getDocument().addDocumentListener(originLongitudeActionListener);
        originPanel.add(originLatitudeField);
        originPanel.add(originLongitudeField);
        return originPanel;
    }

    private JPanel initDestinationPanel() {
        JPanel destinationPanel = new JPanel();
        destinationPanel.setLayout(new GridLayout(2, 1));
        JTextField destinationLatitudeField = new JTextField();
        destinationLatitudeActionListener = new EditAction(destinationLatitudeField);
        destinationLatitudeField.getDocument().addDocumentListener(destinationLatitudeActionListener);
        JTextField destinationLongitudeField = new JTextField();
        destinationLongitudeActionListener = new EditAction(destinationLongitudeField);
        destinationLatitudeField.getDocument().addDocumentListener(destinationLongitudeActionListener);
        destinationPanel.add(destinationLatitudeField);
        destinationPanel.add(destinationLongitudeField);
        return destinationPanel;
    }

    private JPanel initResultPanel() {
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new GridLayout(2, 1));
        JButton calculateButton = new JButton(TranslationHelper.getMessage("app.calculate"));
        JLabel resultLabel = new JLabel(TranslationHelper.getMessage("app.result"));
        resultPanel.add(calculateButton);
        resultPanel.add(resultLabel);
        calculateButton.addMouseListener(new CalculateAction(originLatitudeActionListener,
                                                            originLongitudeActionListener,
                                                            destinationLatitudeActionListener,
                                                            destinationLongitudeActionListener,
                                                            resultLabel));
        return resultPanel;
    }
}
