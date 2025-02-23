package com.hanks.demo;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hanks.passcodeview.PasscodeView;

/**
 * Created by hanks on 2017/4/17.
 */

public class PasscodeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passcode);
        PasscodeView passcodeView = (PasscodeView) findViewById(R.id.passcodeView);
        passcodeView.setListener(new PasscodeView.PasscodeViewListener() {
            @Override
            public void onFail(String wrongNumber) {
                Toast.makeText(getApplication(),"Wrong!!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String number) {
                Toast.makeText(getApplication(),"finish",Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }
}
