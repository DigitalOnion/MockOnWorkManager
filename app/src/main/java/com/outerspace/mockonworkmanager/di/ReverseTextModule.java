package com.outerspace.mockonworkmanager.di;

import com.outerspace.mockonworkmanager.backend.TextReverserInterface;
import com.outerspace.mockonworkmanager.backend.TextReverserServer;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ReverseTextModule {
    @Provides
    @Singleton
    public TextReverserInterface provideTextReverse() {
        return TextReverserServer.getInstance();
    }
}
