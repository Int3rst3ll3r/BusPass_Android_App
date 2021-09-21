package com.example.buspass;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.widget.TextView;

import com.example.buspass.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fetch_details extends AppCompatActivity {

    TextView tv;

    String url="https://deponent-necks.000webhostapp.com/";
   // String url="https://autoportalgls.000webhostapp.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_details);

        tv=findViewById(R.id.tv);

        tv.setText("");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        myapi_2 api = retrofit.create(myapi_2.class);

        Call<List<model>> call=api.getmodels();

        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> data = response.body();

                for (int i=0 ; i <data.size();i++)

                {
                    tv.append("company: "+data.get(i).getCompany()+"\n model: "+data.get(i).getModel()+"\n variant: "+data.get(i).getVariant()+"\n year: "+data.get(i).getYear()+"\n color: "+data.get(i).getColor()+"\n km: "+data.get(i).getKmdriven()+"\n owner: "+data.get(i).getOwner()+"\n state: "+data.get(i).getState()+"\n city: "+data.get(i).getCity()+"\n price: "+data.get(i).getPrice()+"\n description: "+data.get(i).getDescription()+"\n \n\n");
                }
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {

            }
        });


    }
}