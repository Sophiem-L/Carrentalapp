package com.example.carrentalapp.ui.theme.home;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;

public class BookingDetailsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_details);

        findViewById(R.id.btn_back_booking).setOnClickListener(v -> finish());

        findViewById(R.id.btn_pay_now).setOnClickListener(v -> {
            showSuccessDialog();
        });
    }

    private void showSuccessDialog() {
        android.app.Dialog dialog = new android.app.Dialog(this);
        dialog.setContentView(R.layout.dialog_booking_success);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        dialog.findViewById(R.id.btn_back_to_home).setOnClickListener(v -> {
            dialog.dismiss();
            finish();
        });

        dialog.show();
    }
}
