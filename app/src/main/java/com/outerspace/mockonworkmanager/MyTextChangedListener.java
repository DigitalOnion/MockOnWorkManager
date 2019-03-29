package com.outerspace.mockonworkmanager;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

public class MyTextChangedListener implements TextWatcher {

    public interface MyTextChangedInterface {
        void onTextChanged(CharSequence text);
    }

    private MyTextChangedInterface caller;

    public MyTextChangedListener(MyTextChangedInterface caller) {
        this.caller = caller;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        caller.onTextChanged(s);
    }

    @Override
    public void afterTextChanged(Editable s) { }
}
