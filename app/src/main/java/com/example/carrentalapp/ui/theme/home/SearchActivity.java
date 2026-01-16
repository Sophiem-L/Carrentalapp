package com.example.carrentalapp.ui.theme.home;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        findViewById(R.id.btn_back).setOnClickListener(v -> finish());

        // Navigation back to home from bottom nav
        findViewById(R.id.nav_home_search).setOnClickListener(v -> finish());
    }
}
