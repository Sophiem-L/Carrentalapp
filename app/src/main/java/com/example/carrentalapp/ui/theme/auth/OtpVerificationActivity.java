package com.example.carrentalapp.ui.theme.auth;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;
import com.example.carrentalapp.ui.theme.home.HomeActivity;

public class OtpVerificationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);

        findViewById(R.id.btn_continue_otp).setOnClickListener(v -> {
            startActivity(new Intent(this, HomeActivity.class));
            finishAffinity(); // Clear stack and start home
        });
    }
}
