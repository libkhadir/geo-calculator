package com.github.libkhadir.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class TranslationHelper {
    public static ResourceBundle bundle;

    public static String getMessage(final String key) {
        if (bundle == null) {
            bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
        }
        return bundle.getString(key);
    }
}
