package com.example.carrentalapp.ui.theme.auth;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;

public class PhoneVerificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);

        findViewById(R.id.btn_continue_verification).setOnClickListener(v -> {
            startActivity(new Intent(this, OtpVerificationActivity.class));
        });
    }
}
