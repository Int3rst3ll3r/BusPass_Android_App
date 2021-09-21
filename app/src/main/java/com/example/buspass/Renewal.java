package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

public class Renewal extends AppCompatActivity {

    Spinner spinner1,spinner2;

    EditText et1;

    DatePickerDialog.OnDateSetListener onDateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renewal);

        spinner1= findViewById(R.id.spinner2);
        spinner2= findViewById(R.id.spinner1);

        spinner1.setEnabled(false);
        spinner2.setEnabled(false);

        et1 = findViewById(R.id.dateview);

        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(Renewal.this,onDateSetListener,year,month,day);


                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);



                datePickerDialog.show();
            }
        });


        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                month = month + 1;

                String date = dayOfMonth + "/" + month + "/" + year;

                et1.setText(date);
            }

        };
    }
}