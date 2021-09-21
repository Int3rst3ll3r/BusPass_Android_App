package com.example.buspass;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.buspass.modelresponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginTabFragment extends Fragment implements View.OnClickListener {

    EditText email, pass;
    Button btn_login;
    SharedPrefManager sharedPrefManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);

        email = root.findViewById(R.id.email);
        pass = root.findViewById(R.id.pass);
        btn_login = root.findViewById(R.id.btn_login);

        sharedPrefManager = new SharedPrefManager(getContext());

        btn_login.setOnClickListener(this);

        return root;
    }

    private void userlogin() {

        String useremail = email.getText().toString();
        String userpass = pass.getText().toString();


        if (useremail.isEmpty()) {
            email.requestFocus();
            email.setError("Please Enter Your Email");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(useremail).matches()) {
            email.requestFocus();
            email.setError("Please Enter correct Email");
            return;
        }

        if (userpass.isEmpty()) {
            pass.requestFocus();
            pass.setError("Please Enter Your Password");
            return;
        }

        if (userpass.length() < 8) {
            pass.requestFocus();
            pass.setError("Please Enter Your Password Greater Than 8");
            return;
        }

        Call<LoginResponse> call = retrofitclient
                .getInstance()
                .getApi().
                        login(useremail, userpass);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();
                if (response.isSuccessful()) {

                    if (loginResponse.getError().equals("200")) {
                        sharedPrefManager.saveUser(loginResponse.getUser());

                        if (loginResponse.getMessage().equals("login success")) {
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            Toast.makeText(getActivity(), loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getActivity(), loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();

        if (sharedPrefManager.isLoggedIn()) {

            Intent intent = new Intent(getActivity(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_login:

                userlogin();

                break;

        }
    }
}