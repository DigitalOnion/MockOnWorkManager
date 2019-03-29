package com.outerspace.mockonworkmanager;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ReverseTextModule.class)
public interface TextReverseComponent {
    void inject(ReverseTextWorker worker);
}
