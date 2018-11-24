package com.mukesh.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.mukesh.OnOtpCompletionListener;
import com.mukesh.OtpView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        OnOtpCompletionListener {

    private Button validate;
    private Button clear;
    private OtpView otpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeUi();
        setListeners();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.validate:
                Toast.makeText(this, otpView.getText(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.clear:
                otpView.clear();
                break;
            default:
                break;
        }
    }

    private void initializeUi() {
        otpView = findViewById(R.id.otp_view);
        validate = findViewById(R.id.validate);
        clear = findViewById(R.id.clear);
    }

    private void setListeners() {
        validate.setOnClickListener(this);
        clear.setOnClickListener(this);
        otpView.setOtpCompletionListener(this);
    }

    @Override
    public void onOtpCompleted(String otp) {
        // do Stuff
        Toast.makeText(this, "OnOtpCompletionListener called", Toast.LENGTH_SHORT).show();
    }
}
