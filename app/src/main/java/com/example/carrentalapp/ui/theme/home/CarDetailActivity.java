package com.example.carrentalapp.ui.theme.home;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;

public class CarDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        findViewById(R.id.btn_back_detail).setOnClickListener(v -> finish());

        findViewById(R.id.btn_book_now).setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, BookingDetailsActivity.class));
        });
    }
}
