package com.example.carrentalapp.ui.theme.home;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
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

                // Set click listeners for car cards to open detail page
                if (findViewById(R.id.ll_car_grid) != null) {
                        ViewGroup grid = findViewById(R.id.ll_car_grid);
                        for (int i = 0; i < grid.getChildCount(); i++) {
                                grid.getChildAt(i).setOnClickListener(v -> {
                                        startActivity(new Intent(this, CarDetailActivity.class));
                                });
                                // Also handle inner button specifically if layout contains it
                                View btn = grid.getChildAt(i).findViewWithTag("book_button");
                                if (btn != null)
                                        btn.setOnClickListener(v -> {
                                                startActivity(new Intent(this, CarDetailActivity.class));
                                        });
                        }
                }
        }
}
