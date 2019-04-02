package com.outerspace.mockonworkmanager;

import androidx.annotation.Nullable;

public class TextReverser {
    private static final TextReverser instance = new TextReverser();
    private static boolean allCaps = false;

    private TextReverser() { }

    public static TextReverser getInstance() {
        allCaps = false;
        return instance;
    }

    public static TextReverser getInstance(boolean allCaps) {
        TextReverser.allCaps = allCaps;
        return instance;
    }

    public String reverse(@Nullable String s) {
        if(s != null) {
            if(allCaps) { s = s.toUpperCase(); }
            char[] a = s.toCharArray();
            int i = 0;
            int j = a.length - 1;

            while(i < j) {
                char t = a[i];
                a[i] = a[j];
                a[j] = t;
                j--;
                i++;
            }
            return new String(a);
        } else {
            return "";
        }
    }
}
