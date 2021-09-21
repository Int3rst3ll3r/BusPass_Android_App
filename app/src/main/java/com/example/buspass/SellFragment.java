package com.example.buspass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buspass.modelresponse.LoginResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SellFragment extends Fragment {
    TextView tv;

    String url = "https://deponent-necks.000webhostapp.com/";

//    private WebView webView;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sell, container, false);


       /*  webView = view.findViewById(R.id.webview);

        // webView.loadUrl("https://routemaps.info/route/ahmedabad-city-bus/");
         webView.loadUrl("https://moovitapp.com/index/hi/%E0%A4%B8%E0%A4%BE%E0%A4%B0%E0%A5%8D%E0%A4%B5%E0%A4%9C%E0%A4%A8%E0%A4%BF%E0%A4%95_%E0%A4%AA%E0%A4%B0%E0%A4%BF%E0%A4%B5%E0%A4%B9%E0%A4%A8-lines-Ahmedabad-1-4504-956470");

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient());
*/

        tv = view.findViewById(R.id.tv);

        tv.setText("");


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        myapi_2 api = retrofit.create(myapi_2.class);

        Call<List<model>> call = api.getmodels();

        call.enqueue(new Callback<List<model>>() {
            @Override
            public void onResponse(Call<List<model>> call, Response<List<model>> response) {
                List<model> data = response.body();

                for (int i = 0; i < data.size(); i++) {
                    tv.append(" company: " + data.get(i).getCompany() + "\n model: " + data.get(i).getModel() + "\n variant: " + data.get(i).getVariant() + "\n year: " + data.get(i).getYear() + "\n color: " + data.get(i).getColor() + "\n km: " + data.get(i).getKmdriven() + "\n owner: " + data.get(i).getOwner() + "\n state: " + data.get(i).getState() + "\n city: " + data.get(i).getCity() + "\n price: " + data.get(i).getPrice() + "\n description: " + data.get(i).getDescription() + "\n \n\n");
                }
            }

            @Override
            public void onFailure(Call<List<model>> call, Throwable t) {

            }
        });


        return view;
    }
}

