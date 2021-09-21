package com.example.buspass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Wallet extends AppCompatActivity implements PaymentResultListener {

    Button buttonpay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        buttonpay = findViewById(R.id.tax);

        String samount = "100";

        int amount = Math.round(Float.parseFloat(samount) * 100);

        buttonpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Checkout checkout = new Checkout();

                checkout.setKeyID("rzp_test_BIi4zMnQPWWfEk");

                checkout.setImage(R.drawable.razor);

                JSONObject object = new JSONObject();

                try {

                    object.put("name","E-Pass");

                    object.put("description","Test Payment");

                    object.put("theme.color","#0093DD");

                    object.put("currency","INR");

                    object.put("amount",amount);

                    object.put("prefill.contact","9998054407");

                    object.put("prefill.email","nagarparth83@gmail.com");

                    checkout.open(Wallet.this,object);



                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public void onPaymentSuccess(String s) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Payment ID");

        builder.setMessage(s);

        builder.show();
    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}