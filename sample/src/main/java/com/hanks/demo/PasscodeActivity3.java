package com.hanks.demo;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.hanks.passcodeview.PasscodeView;

public class PasscodeActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_passcode3);
        PasscodeView passcodeView = (PasscodeView) findViewById(R.id.passcodeView);
        passcodeView
                .setPasscodeLength(4)
                .setLocalPasscode("5555")
                .setListener(new PasscodeView.PasscodeViewListener() {
                    @Override
                    public void onFail(String wrongNumber) {
                        Toast.makeText(getApplication(),"Wrong!!",Toast.LENGTH_SHORT).show();
                    }

            @Override
            public void onSuccess(String number) {
                Toast.makeText(getApplication(), "finish", Toast.LENGTH_SHORT).show();
                onBackPressed();
            }
        });
    }

}
