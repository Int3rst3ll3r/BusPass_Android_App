package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RateList extends AppCompatActivity {

    private ExpandableListView expandablelistview;
    HashMap<String, List<String>> listchild;
    List<String> listHeader;
   // CustomeAdopter customAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_list);


        expandablelistview = findViewById(R.id.Expandlist_item);

        listchild = ExpendableListData.getData();

        listHeader = new ArrayList<String>(listchild.keySet());

     /*   customAdopter = new CustomeAdopter(this, listchild, listHeader);
        expandablelistview.setAdapter(customAdopter);
*/




    }
}