package com.example.carrentalapp.ui.theme.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.carrentalapp.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class FilterBottomSheetFragment extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_filter, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_close_filter).setOnClickListener(v -> dismiss());
        view.findViewById(R.id.btn_show_cars).setOnClickListener(v -> dismiss());
        view.findViewById(R.id.tv_clear_all).setOnClickListener(v -> {
            // Logic to clear filters can be added here
        });

        view.findViewById(R.id.rl_date_picker_trigger).setOnClickListener(v -> {
            FilterDatePickerDialog.newInstance().show(getChildFragmentManager(), "DatePicker");
        });
    }

    @Override
    public int getTheme() {
        // Use a theme with rounded corners if available, or just the default
        return super.getTheme();
    }
}
