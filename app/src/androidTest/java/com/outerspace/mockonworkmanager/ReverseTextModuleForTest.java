package com.outerspace.mockonworkmanager;

import com.outerspace.mockonworkmanager.backend.TextReverserInterface;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ReverseTextModuleForTest {

    @Provides
    @Singleton
    public TextReverserInterface provideTextReverse() {
        return new TextReverserFake();
    }
}
