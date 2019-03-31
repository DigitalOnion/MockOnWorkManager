package com.outerspace.mockonworkmanager.di;

import com.outerspace.mockonworkmanager.TextReverser;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ReverseTextModule {
    @Provides
    @Singleton
    public TextReverser provideTextReverse() {
        return TextReverser.getInstance();
    }
}
