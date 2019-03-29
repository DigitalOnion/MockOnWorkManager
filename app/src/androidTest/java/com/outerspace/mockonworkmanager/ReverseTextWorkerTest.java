package com.outerspace.mockonworkmanager;

import android.content.Context;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.work.Configuration;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.testing.SynchronousExecutor;
import androidx.work.testing.WorkManagerTestInitHelper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ReverseTextWorkerTest {

    @Before
    public void setup() {
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Configuration config = new Configuration.Builder()
                .setMinimumLoggingLevel(Log.DEBUG)
                .setExecutor(new SynchronousExecutor())
                .build();

        WorkManagerTestInitHelper.initializeTestWorkManager(context, config);
    }

    @Test
    public void testReverseTextWorker() throws Exception {
        Data dataText = new Data.Builder()
                .putString(MainActivity.INPUT_TEXT, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                .build();

        OneTimeWorkRequest reverseTextWorkRequest = new OneTimeWorkRequest.Builder(ReverseTextWorker.class)
                .setInputData(dataText)
                .build();

        WorkManager workManager = WorkManager.getInstance();

        workManager.enqueue(reverseTextWorkRequest).getResult().get();

        WorkInfo workInfo = workManager.getWorkInfoById(reverseTextWorkRequest.getId()).get();
        Data dataOutput = workInfo.getOutputData();
        String output = dataOutput.getString(MainActivity.OUTPUT_TEXT);

        assertThat(workInfo.getState(), is(WorkInfo.State.SUCCEEDED));
        assertThat(output, is("ZYXWVUTSRQPONMLKJIHGFEDCBA"));
    }
}
