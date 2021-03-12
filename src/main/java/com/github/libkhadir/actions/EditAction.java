package com.github.libkhadir.actions;

import lombok.Getter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class EditAction implements DocumentListener {
    @Getter double value;
    JTextField text;

    public EditAction(final JTextField text){
        this.text = text;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        try {
            value = Double.valueOf(text.getText());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        try {
            value = Double.valueOf(text.getText());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        try {
            value = Double.valueOf(text.getText());
        } catch (NumberFormatException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
