package com.outerspace.mockonworkmanager;

import androidx.annotation.Nullable;

public class TextReverser {
    public static String reverse(@Nullable String s) {
        if(s != null) {
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
