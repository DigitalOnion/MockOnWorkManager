package com.outerspace.mockonworkmanager;

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
