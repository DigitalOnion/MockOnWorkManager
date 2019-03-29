package com.outerspace.mockonworkmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class ReverseTextWorker extends Worker {

    public ReverseTextWorker(
            @NonNull Context context,
            @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        String inputText = getInputData().getString(MainActivity.INPUT_TEXT);

        String reverseText = TextReverser.reverse(inputText); // dependency inside a worker

        Data reverseData = new Data.Builder()
                .putString(MainActivity.OUTPUT_TEXT, reverseText)
                .build();

        return Result.success(reverseData);
    }
}
