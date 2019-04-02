package com.outerspace.mockonworkmanager;

import com.outerspace.mockonworkmanager.di.ReverseTextComponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ReverseTextModuleForTest.class)
    public interface ReverseTextComponentForTest extends ReverseTextComponent {
        void inject(ReverseTextWorkerForTest worker);
}
