package com.example.carrentalapp.ui.theme.Vehiclcatalog;

public class VehicleListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Vehicle> vehicles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list);

        recyclerView = findViewById(R.id.recyclerVehicles);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Toyota Corolla", "$40/day"));
        vehicles.add(new Vehicle("Honda Civic", "$45/day"));

        VehicleAdapter adapter = new VehicleAdapter(vehicles);
        recyclerView.setAdapter(adapter);
    }
}

