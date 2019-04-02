package com.outerspace.mockonworkmanager;

import com.outerspace.mockonworkmanager.TextReverser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ReverseTextModuleForTest {

    @Provides
    @Singleton
    public TextReverser provideTextReverse() {
        return TextReverser.getInstance(true);
    }
}
