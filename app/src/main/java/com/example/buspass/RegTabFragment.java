package com.example.buspass;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.buspass.modelresponse.RegisterResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegTabFragment extends Fragment implements View.OnClickListener {

    EditText name, email, pass, confirm_pass, gender, contact, city, state, address;
    Button btn_reg;
    RadioGroup rg;
    RadioButton radioButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.reg_tab_fragment, container, false);

        name = root.findViewById(R.id.names);
        email = root.findViewById(R.id.emails);
        pass = root.findViewById(R.id.passs);
        confirm_pass = root.findViewById(R.id.confirm_passs);
        rg=root.findViewById(R.id.radioGroup);
        contact = root.findViewById(R.id.contact);
        address = root.findViewById(R.id.address);
        city = root.findViewById(R.id.city);
        state = root.findViewById(R.id.state);
        btn_reg = root.findViewById(R.id.btn_reg);


        btn_reg.setOnClickListener(this);

        return root;
    }

    private void registeruser() {

        String username = name.getText().toString();
        String useremail = email.getText().toString();
        String userpass = pass.getText().toString();
        String userconpass = confirm_pass.getText().toString();
        int radioid= rg.getCheckedRadioButtonId();
        radioButton= getView().findViewById(radioid);
        String usergender = radioButton.getText().toString();
        String usercontact = contact.getText().toString();
        String useradd = address.getText().toString();
        String usercity = city.getText().toString();
        String userstate = state.getText().toString();


        if(username.isEmpty())
        {
            name.requestFocus();
            name.setError("Please Enter Your Name");
            return;
        }
        if(useremail.isEmpty())
        {
            email.requestFocus();
            email.setError("Please Enter Your Email");
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(useremail).matches())

        {
            email.requestFocus();
            email.setError("Please Enter correct Email");
            return;
        }

        if(userpass.isEmpty())
        {
            pass.requestFocus();
            pass.setError("Please Enter Your Password");
            return;
        }

        if(userpass.length() <8)
        {
            pass.requestFocus();
            pass.setError("Please Enter Your Password Greater Than 8");
            return;
        }

        if(userconpass.isEmpty())
        {
            confirm_pass.requestFocus();
            confirm_pass.setError("Please Enter Your Conform Password");
            return;
        }

        if(!userconpass.equals(userpass))
        {
            confirm_pass.requestFocus();
            confirm_pass.setError("Please Enter Same Password");
            return;
        }

        if(usergender.isEmpty())
        {
            gender.requestFocus();
            gender.setError("Please Enter Your Gender");
            return;
        }


        if(usercontact.isEmpty())
        {
            contact.requestFocus();
            contact.setError("Please Enter Your Contact No");
            return;
        }

        if(useradd.isEmpty())
        {
            address.requestFocus();
            address.setError("Please Enter Your Address");
            return;
        }

        if(usercity.isEmpty())
        {
            city.requestFocus();
            city.setError("Please Enter Your City");
            return;
        }

        if(userstate.isEmpty())
        {
            state.requestFocus();
            state.setError("Please Enter Your State");
            return;
        }

        Call<RegisterResponse> call=retrofitclient
                .getInstance()
                .getApi()
                .register(username,useremail,userpass,userconpass,usergender,usercontact,useradd,usercity,userstate);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                RegisterResponse registerResponse=response.body();

                if (response.isSuccessful()){
                    Toast.makeText(getActivity(),registerResponse.getMessage(),Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getActivity(), registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_reg:

                registeruser();

                break;

        }

    }
}


