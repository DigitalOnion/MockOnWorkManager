package com.outerspace.mockonworkmanager;

import com.outerspace.mockonworkmanager.backend.TextReverserInterface;

import androidx.annotation.Nullable;

/**
 * TextReverserFake
 *
 * Implements the TextReverserInterface to fake the TextReverserServer. Being a fake,
 * this class will not do the process of the sever, but it will do some simpler process
 * that we could verify it is working.
 *
 * In this case, and for this exercise, instead of reversing the string,
 * the fake server will only return the Upper Case version of the input.
 */
public class TextReverserFake implements TextReverserInterface {
    @Override
    public String reverse(@Nullable String s) {
        if(s != null)
            return s.toUpperCase();
        else
            return "";
    }
}
