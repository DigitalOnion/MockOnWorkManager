package com.outerspace.mockonworkmanager;

import android.content.Context;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ReverseTextWorker extends Worker {

    @Inject TextReverser reverser; // = TextReverser.getInstance();  // dependency inside a worker

    public ReverseTextWorker(
            @NonNull Context context,
            @NonNull WorkerParameters workerParams) {
        super(context, workerParams);

        TextReverseComponent component = DaggerTextReverseComponent.create();
        component.inject(this);
    }

    @NonNull
    @Override
    public Result doWork() {
        String inputText = getInputData().getString(MainActivity.INPUT_TEXT);

        String reverseText = reverser.reverse(inputText);

        Data reverseData = new Data.Builder()
                .putString(MainActivity.OUTPUT_TEXT, reverseText)
                .build();

        return Result.success(reverseData);
    }
}
