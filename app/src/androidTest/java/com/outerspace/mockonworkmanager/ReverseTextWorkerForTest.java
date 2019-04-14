package com.outerspace.mockonworkmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.WorkerParameters;

/**
 * ReverseTextWorkerForTest
 *
 * it extends the ReverseTextWorker to override the init method. By doing so,
 * we can test the ReverseTextWorker's logic with a Fake Server.
 */

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
