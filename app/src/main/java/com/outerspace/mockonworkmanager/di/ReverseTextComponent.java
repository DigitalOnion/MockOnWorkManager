package com.outerspace.mockonworkmanager.di;

import com.outerspace.mockonworkmanager.ReverseTextWorker;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ReverseTextModule.class)
public interface ReverseTextComponent {
    void inject(ReverseTextWorker worker);
}
