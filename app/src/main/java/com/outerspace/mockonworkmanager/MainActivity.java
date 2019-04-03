package com.outerspace.mockonworkmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements MyTextChangedListener.MyTextChangedInterface {

    public static final String INPUT_TEXT = "input_text";
    public static final String OUTPUT_TEXT = "output_text";

    EditText inputText;
    TextView outputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.input_text);
        outputText = findViewById(R.id.output_text);

        MyTextChangedListener listener = new MyTextChangedListener(this);

        inputText.addTextChangedListener(listener);

        WebView webIntro = findViewById(R.id.intro);
        webIntro.loadUrl("file:///android_asset/intro.html");
    }

    @Override
    public void onTextChanged(CharSequence text) {
        // outputText.setText(text);
        Data dataText = new Data.Builder()
                .putString(INPUT_TEXT, text.toString())
                .build();

        OneTimeWorkRequest reverseTextWorkRequest = new OneTimeWorkRequest.Builder(ReverseTextWorker.class)
                .setInputData(dataText)
                .build();

        WorkManager.getInstance().enqueue(reverseTextWorkRequest);

        UUID uuid = reverseTextWorkRequest.getId();
        WorkManager.getInstance().getWorkInfoByIdLiveData(uuid)
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(WorkInfo workInfo) {
                        Data dataOutput = workInfo.getOutputData();
                        String output = dataOutput.getString(OUTPUT_TEXT);
                        if(output != null) {
                            outputText.setText(output);
                        }
                    }
                });

    }
}
