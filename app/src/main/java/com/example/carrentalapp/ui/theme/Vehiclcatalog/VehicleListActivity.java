package com.example.carrentalapp.ui.theme.Vehiclcatalog;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carrentalapp.R;
import com.example.carrentalapp.model.Vehicle;
import com.example.carrentalapp.model.VehicleAdapter;

import java.util.ArrayList;
import java.util.List;

public class VehicleListActivity extends AppCompatActivity {

    // 1. Declare your variables here so the methods can see them
    private RecyclerView recyclerView;
    private List<Vehicle> vehicles;
    private VehicleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list); // Make sure this XML file exists

        // 2. Initialize the RecyclerView from the layout
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. Initialize and populate the list
        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Toyota Corolla", "$40/day"));
        vehicles.add(new Vehicle("Honda Civic", "$45/day"));

        // 4. Set up the adapter
        adapter = new VehicleAdapter(vehicles);
        recyclerView.setAdapter(adapter);
    }
}