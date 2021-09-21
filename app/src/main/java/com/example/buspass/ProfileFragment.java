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
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.buspass.modelresponse.DeleteResponse;
import com.example.buspass.modelresponse.LoginResponse;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.textfield.TextInputEditText;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileFragment extends Fragment implements View.OnClickListener {

    EditText name,email,contact,address,city,state;

    SharedPrefManager sharedPrefManager;

    Button userupdate;

    RadioGroup rg;

    RadioButton radioButton;

    int userId;

    private View view;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_profile,container,false);

     //       tv1=view.findViewById(R.id.et1);
       //     tv2=view.findViewById(R.id.et2);

        sharedPrefManager = new SharedPrefManager(getActivity());
           userId=sharedPrefManager.getUser().getId();

        name=view.findViewById(R.id.proname);
        email=view.findViewById(R.id.proemail);
        rg=view.findViewById(R.id.radioGroup);
        contact=view.findViewById(R.id.prophone);
        address=view.findViewById(R.id.proaddress);
        city=view.findViewById(R.id.procity);
        state=view.findViewById(R.id.prostate);

        userupdate=view.findViewById(R.id.btn_update);
//
        userupdate.setOnClickListener(this);

         /*   String username="Hey " + sharedPrefManager.getUser().getUsername();
            tv1.setText(username);
            tv2.setText(sharedPrefManager.getUser().getEmail());


         /*   String username="Hey " + sharedPrefManager.getUser().getUsername();
            tv1.setText(username);
            tv2.setText(sharedPrefManager.getUser().getEmail());

*/
            return view;

    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull @NotNull Menu menu, @NonNull @NotNull MenuInflater inflater) {

        inflater.inflate(R.menu.logoutmenu,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull @NotNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.logout:
                logoutUser();
                break;

            case R.id.delete:
                deleteAccount();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void deleteAccount() {

        Call<DeleteResponse> call=retrofitclient
                .getInstance()
                .getApi()
                .deleteuser(sharedPrefManager.getUser().getId());

        call.enqueue(new Callback<DeleteResponse>() {
            @Override
            public void onResponse(Call<DeleteResponse> call, Response<DeleteResponse> response) {

                DeleteResponse deleteResponse=response.body();

                if (response.isSuccessful()) {

                    if (deleteResponse.getError().equals("200")) {
                        logoutUser();
                        Toast.makeText(getActivity(), deleteResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), deleteResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(getActivity(), "failed", Toast.LENGTH_SHORT).show();

                }
                }


            @Override
            public void onFailure(Call<DeleteResponse> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void logoutUser() {

        sharedPrefManager.logout();
        Intent intent=new Intent(getActivity(), TabItem.class);

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);

        Toast.makeText(getActivity(),"You have been loggedout",Toast.LENGTH_LONG).show();




    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.btn_update:
                updateuseraccount();
                break;
        }
    }

    private void updateuseraccount() {

        String username = name.getText().toString().trim();
        String useremail = email.getText()  .toString().trim();
        int radioid= rg.getCheckedRadioButtonId();
        radioButton=getView().findViewById(radioid);
        String usergender = radioButton.getText().toString().trim();
        String usercontact= contact.getText().toString().trim();
        String useradd = address.getText().toString().trim();
        String usercity = city.getText().toString().trim();
        String userstate = state.getText().toString().trim();

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


        Call<LoginResponse> call= retrofitclient.
                getInstance()
                .getApi()
                .updateuseraccount(userId,username,useremail,usergender,usercontact,useradd,usercity,userstate);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse updateresponse=response.body();

                if(response.isSuccessful()) {
                    if (updateresponse.getError().equals("200")) {

                         sharedPrefManager.saveUser(updateresponse.getUser());
                        Toast.makeText(getActivity(), updateresponse.getMessage(), Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(getActivity(), updateresponse.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                    else {

                    Toast.makeText(getActivity(), "Failed", Toast.LENGTH_SHORT).show();

                }

                }


            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

                Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });



    }
}
