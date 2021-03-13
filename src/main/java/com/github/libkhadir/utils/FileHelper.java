package com.github.libkhadir.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHelper {

    public static List<String> readAll(final String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }
}
