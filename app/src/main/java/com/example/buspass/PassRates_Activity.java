package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PassRates_Activity extends AppCompatActivity {

    private RecyclerView rcPassList;
    private ArrayList<PassRate_Model> Passrate_model_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_rates);

        rcPassList = findViewById(R.id.RCPassRates);

        Passrate_model_list = new ArrayList<PassRate_Model>();


        Passrate_model_list.add(new PassRate_Model("AMTS",R.drawable.amts));
        Passrate_model_list.add(new PassRate_Model("Brts",R.drawable.brts));
        Passrate_model_list.add(new PassRate_Model("St",R.drawable.st));

        LinearLayoutManager manager = new LinearLayoutManager(this);
        rcPassList.setLayoutManager(manager);

        Pass_rate_Adopter pass_rate_adopter = new Pass_rate_Adopter(this,Passrate_model_list);
        pass_rate_adopter.setItems(Passrate_model_list);
        rcPassList.setAdapter(pass_rate_adopter);


    }
}