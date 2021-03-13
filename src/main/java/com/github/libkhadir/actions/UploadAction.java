package com.github.libkhadir.actions;

import com.github.libkhadir.ui.MassUploadFrame;
import com.github.libkhadir.utils.FileHelper;
import com.github.libkhadir.utils.MathHelper;
import lombok.SneakyThrows;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

public class UploadAction implements MouseListener {
    @SneakyThrows
    @Override
    public void mouseClicked(MouseEvent e) {
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            new MassUploadFrame(MathHelper.distances(FileHelper.readAll(selectedFile.getAbsolutePath())));
        }
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
}
