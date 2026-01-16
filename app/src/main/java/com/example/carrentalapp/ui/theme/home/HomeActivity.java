package com.example.carrentalapp.ui.theme.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.carrentalapp.R;
import com.example.carrentalapp.ui.theme.Vehiclcatalog.VehicleListActivity;
import com.example.carrentalapp.ui.theme.locationdate.LocationDatePickerActivity;
import com.example.carrentalapp.ui.theme.booking.BookingActivity;
import com.example.carrentalapp.ui.theme.payment.PaymentActivity;
import com.example.carrentalapp.ui.theme.contract.DigitalContractActivity;
import com.example.carrentalapp.ui.theme.insurance.insuranceSelectionActivity;
import com.example.carrentalapp.ui.theme.support.SupportChatActivity;
import com.example.carrentalapp.ui.theme.review.ReviewRatingActivity;
import com.example.carrentalapp.ui.theme.logs.ActivityLogsActivity;
import com.example.carrentalapp.ui.theme.admin.RolePermissionActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        findViewById(R.id.btn_vehicle_catalog)
                .setOnClickListener(v -> startActivity(new Intent(this, VehicleListActivity.class)));

        findViewById(R.id.btn_location_date)
                .setOnClickListener(v -> startActivity(new Intent(this, LocationDatePickerActivity.class)));

        findViewById(R.id.btn_booking).setOnClickListener(v -> startActivity(new Intent(this, BookingActivity.class)));

        findViewById(R.id.btn_payment).setOnClickListener(v -> startActivity(new Intent(this, PaymentActivity.class)));

        findViewById(R.id.btn_contract)
                .setOnClickListener(v -> startActivity(new Intent(this, DigitalContractActivity.class)));

        findViewById(R.id.btn_insurance)
                .setOnClickListener(v -> startActivity(new Intent(this, insuranceSelectionActivity.class)));

        findViewById(R.id.btn_support)
                .setOnClickListener(v -> startActivity(new Intent(this, SupportChatActivity.class)));

        findViewById(R.id.btn_reviews)
                .setOnClickListener(v -> startActivity(new Intent(this, ReviewRatingActivity.class)));

        findViewById(R.id.btn_logs)
                .setOnClickListener(v -> startActivity(new Intent(this, ActivityLogsActivity.class)));

        findViewById(R.id.btn_roles)
                .setOnClickListener(v -> startActivity(new Intent(this, RolePermissionActivity.class)));
    }
}
