package com.example.carrentalapp.ui.theme.home;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;

public class SearchActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        findViewById(R.id.btn_back).setOnClickListener(v -> finish());

        // Show filters bottom sheet
        findViewById(R.id.btn_filter_search).setOnClickListener(v -> {
            FilterBottomSheetFragment filterSheet = new FilterBottomSheetFragment();
            filterSheet.show(getSupportFragmentManager(), "FilterBottomSheet");
        });

        // Navigation back to home from bottom nav
        findViewById(R.id.nav_home_search).setOnClickListener(v -> finish());

        // Set click listeners for car cards in search grid
        if (findViewById(R.id.ll_recommend_grid) != null) {
            ViewGroup grid = findViewById(R.id.ll_recommend_grid);
            for (int i = 0; i < grid.getChildCount(); i++) {
                View row = grid.getChildAt(i);
                if (row instanceof ViewGroup) {
                    ViewGroup rowGroup = (ViewGroup) row;
                    for (int j = 0; j < rowGroup.getChildCount(); j++) {
                        rowGroup.getChildAt(j).setOnClickListener(v -> {
                            startActivity(new Intent(this, CarDetailActivity.class));
                        });
                        // Add IDs and link them if needed, but card click is sufficient if buttons
                        // don't consume it.
                        // I'll leave it as is for now since it covers the entire area.
                    }
                }
            }
        }
    }
}
