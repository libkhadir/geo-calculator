package com.github.libkhadir.actions;

import com.github.libkhadir.model.Point;
import com.github.libkhadir.utils.MathHelper;
import lombok.AllArgsConstructor;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

@AllArgsConstructor
public class CalculateAction implements MouseListener {
    private EditAction originLatitudeActionListener;
    private EditAction originLongitudeActionListener;
    private EditAction destinationLatitudeActionListener;
    private EditAction destinationLongitudeActionListener;
    private JLabel resultLabel;

    @Override
    public void mouseClicked(MouseEvent e) {
        refresh();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    private void refresh() {
        double distance = MathHelper.distance(new Point(originLatitudeActionListener.getValue(), originLongitudeActionListener.getValue()),
                new Point(destinationLatitudeActionListener.getValue(), destinationLongitudeActionListener.getValue()));
        this.resultLabel.setText(resultLabel.getText() + " : " + distance);
    }
}
