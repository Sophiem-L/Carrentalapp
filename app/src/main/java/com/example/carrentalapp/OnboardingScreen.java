package com.example.carrentalapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class OnboardingScreen extends AppCompatActivity {

    private int currentPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        ImageView background = findViewById(R.id.background_image);
        TextView title = findViewById(R.id.title_text);
        Button btnGetStarted = findViewById(R.id.get_started_button);

        // Load the first background image immediately
        background.setImageResource(R.drawable.bg_car_1);

        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPage == 1) {
                    // Switch to the second design screen
                    background.setImageResource(R.drawable.bg_car_2);
                    title.setText("Lets Start\nA New Experience\nWith Car rental.");
                    currentPage = 2;
                } else {
                    // This is where you would move to the Login screen
                    // startActivity(new Intent(OnboardingScreen.this, LoginActivity.class));
                }
            }
        });
    }
}