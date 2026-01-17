package com.example.carrentalapp.ui.theme.home;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.carrentalapp.R;

public class FilterDatePickerDialog extends DialogFragment {

    public static FilterDatePickerDialog newInstance() {
        return new FilterDatePickerDialog();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_date_picker, container, false);
    }

    private java.util.Calendar displayCalendar;
    private android.widget.TextView tvMonthYear;
    private android.widget.GridLayout glCalendar;
    private final String[] months = { "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December" };

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        displayCalendar = java.util.Calendar.getInstance();
        tvMonthYear = view.findViewById(R.id.tv_month_year);
        glCalendar = view.findViewById(R.id.gl_calendar);

        view.findViewById(R.id.btn_prev_month).setOnClickListener(v -> {
            displayCalendar.add(java.util.Calendar.MONTH, -1);
            updateCalendar();
        });

        view.findViewById(R.id.btn_next_month).setOnClickListener(v -> {
            displayCalendar.add(java.util.Calendar.MONTH, 1);
            updateCalendar();
        });

        view.findViewById(R.id.btn_cancel_date).setOnClickListener(v -> dismiss());
        view.findViewById(R.id.btn_done_date).setOnClickListener(v -> dismiss());

        updateCalendar();
    }

    private void updateCalendar() {
        tvMonthYear.setText(months[displayCalendar.get(java.util.Calendar.MONTH)] + " "
                + displayCalendar.get(java.util.Calendar.YEAR));
        glCalendar.removeAllViews();

        java.util.Calendar cal = (java.util.Calendar) displayCalendar.clone();
        cal.set(java.util.Calendar.DAY_OF_MONTH, 1);
        int firstDayOfWeek = cal.get(java.util.Calendar.DAY_OF_WEEK) - 1; // 0 for Sunday
        int daysInMonth = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        // Previous month days placeholder
        java.util.Calendar prevMonth = (java.util.Calendar) cal.clone();
        prevMonth.add(java.util.Calendar.MONTH, -1);
        int daysInPrevMonth = prevMonth.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        for (int i = firstDayOfWeek - 1; i >= 0; i--) {
            addDayView(String.valueOf(daysInPrevMonth - i), Color.parseColor("#DDDDDD"), false);
        }

        // Current month days
        int today = java.util.Calendar.getInstance().get(java.util.Calendar.DAY_OF_MONTH);
        boolean isCurrentMonth = displayCalendar.get(java.util.Calendar.MONTH) == java.util.Calendar.getInstance()
                .get(java.util.Calendar.MONTH)
                && displayCalendar.get(java.util.Calendar.YEAR) == java.util.Calendar.getInstance()
                        .get(java.util.Calendar.YEAR);

        for (int i = 1; i <= daysInMonth; i++) {
            boolean isToday = isCurrentMonth && (i == today);
            addDayView(String.valueOf(i), Color.BLACK, isToday);
        }

        // Next month days placeholder
        int remainingCells = 42 - (firstDayOfWeek + daysInMonth); // 6 rows * 7 columns
        for (int i = 1; i <= remainingCells; i++) {
            addDayView(String.valueOf(i), Color.parseColor("#DDDDDD"), false);
        }
    }

    private void addDayView(String day, int textColor, boolean isSelected) {
        android.widget.TextView tv = new android.widget.TextView(getContext());
        tv.setText(day);
        tv.setTextColor(textColor);
        tv.setGravity(android.view.Gravity.CENTER);
        tv.setTextSize(14);
        tv.setTypeface(null, android.graphics.Typeface.BOLD);

        android.widget.GridLayout.LayoutParams params = new android.widget.GridLayout.LayoutParams();
        params.width = 0;
        params.height = (int) (44 * getResources().getDisplayMetrics().density);
        params.columnSpec = android.widget.GridLayout.spec(android.widget.GridLayout.UNDEFINED, 1f);
        tv.setLayoutParams(params);

        if (isSelected) {
            tv.setBackgroundResource(R.drawable.bg_calendar_day_selected);
            tv.setTextColor(Color.WHITE);
        } else {
            tv.setBackgroundResource(android.R.color.transparent);
        }

        tv.setOnClickListener(v -> {
            // Logic for selection can be added here
        });

        glCalendar.addView(tv);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        if (dialog.getWindow() != null) {
            dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        return dialog;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
