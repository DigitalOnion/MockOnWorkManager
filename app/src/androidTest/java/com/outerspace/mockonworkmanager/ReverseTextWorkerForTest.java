package com.outerspace.mockonworkmanager;

import android.content.Context;

import com.outerspace.mockonworkmanager.di.DaggerReverseTextComponent;
import com.outerspace.mockonworkmanager.di.ReverseTextComponent;
import com.outerspace.mockonworkmanager.di.ReverseTextModule;

import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;

public class ReverseTextWorkerForTest extends ReverseTextWorker {
    public ReverseTextWorkerForTest(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @Override
    public void init() {
        ReverseTextComponentForTest component =
                DaggerReverseTextComponentForTest.builder()
                        .reverseTextModuleForTest(new ReverseTextModuleForTest())
                        .build();
        component.inject(this);
    }
}
