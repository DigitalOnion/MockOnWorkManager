package com.outerspace.mockonworkmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyTextChangedListener.MyTextChangedInterface {

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
    }

    @Override
    public void onTextChanged(CharSequence text) {
        outputText.setText(text);
    }
}
