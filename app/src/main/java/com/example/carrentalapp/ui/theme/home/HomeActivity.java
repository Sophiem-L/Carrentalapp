package com.example.carrentalapp.ui.theme.home;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;

public class HomeActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_home);

                // Navigate to Search Page when search bar or nav search icon is clicked
                findViewById(R.id.et_home_search).setOnClickListener(v -> {
                        startActivity(new Intent(this, SearchActivity.class));
                });

                findViewById(R.id.nav_search).setOnClickListener(v -> {
                        startActivity(new Intent(this, SearchActivity.class));
                });

                // Other nav icons (placeholders)
                findViewById(R.id.nav_profile).setOnClickListener(v -> {
                        // Future Profile Activity
                });
        }
}
