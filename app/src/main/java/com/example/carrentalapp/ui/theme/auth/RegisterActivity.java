package com.example.carrentalapp.ui.theme.auth;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        findViewById(R.id.btn_register).setOnClickListener(v -> {
            startActivity(new Intent(this, PhoneVerificationActivity.class));
        });

        findViewById(R.id.btn_login_link).setOnClickListener(v -> {
            finish();
        });

        findViewById(R.id.tv_footer_login).setOnClickListener(v -> {
            finish();
        });
    }
}
