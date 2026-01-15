package com.example.carrentalapp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carrentalapp.R; // Ensure this matches your package name
import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {

    private List<Vehicle> vehicleList;

    public VehicleAdapter(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_vehicle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vehicle vehicle = vehicleList.get(position);
        holder.txtCarName.setText(vehicle.getName());
        holder.txtPrice.setText(vehicle.getPrice());
    }

    @Override
    public int getItemCount() {
        return vehicleList != null ? vehicleList.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtCarName, txtPrice;

        ViewHolder(View itemView) {
            super(itemView);
            txtCarName = itemView.findViewById(R.id.txtCarName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
        }
    }
}