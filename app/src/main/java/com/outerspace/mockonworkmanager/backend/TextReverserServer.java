package com.outerspace.mockonworkmanager.backend;

import androidx.annotation.Nullable;

/**
 * TextReverserServer
 *
 * A backend class will typically provide the interface to some external process,
 * for example an API from a remote server. For the purpose of this exercise, the
 * "Server" provides the Reverse Text service. So the Main Activity and Workers
 * do not need to know how to reverse text.
 *
 */

public class TextReverserServer implements TextReverserInterface {
    private static final TextReverserServer instance = new TextReverserServer();

    private TextReverserServer() { }

    public static TextReverserServer getInstance() {
        return instance;
    }

    @Override
    public String reverse(@Nullable String s) {
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
