package com.example.carrentalapp.ui.theme.auth;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;
import com.example.carrentalapp.ui.theme.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.btn_login);
        if (loginButton != null) {
            loginButton.setOnClickListener(v -> {
                startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                finish();
            });
        }

        findViewById(R.id.btn_signup_link).setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });

        findViewById(R.id.tv_forgot_password).setOnClickListener(v -> {
            startActivity(new Intent(this, ForgotPasswordActivity.class));
        });

        findViewById(R.id.tv_footer_signup).setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity.class));
        });
    }
}
