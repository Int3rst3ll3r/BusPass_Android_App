package com.example.buspass;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.buspass.modelresponse.User;

public class SharedPrefManager {

    private String SHARED_PREF_NAME="Parthngr";

    private SharedPreferences sharedPreferences;
    Context context;

    private SharedPreferences.Editor editor;


    public SharedPrefManager(Context context) {
        this.context = context;
    }

    void saveUser(User user)
    {
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        editor=sharedPreferences.edit();
        editor.putInt("userid", user.getId());
        editor.putString("username", user.getUsername());
        editor.putString("email",user.getEmail());

        editor.putBoolean("logged",true);
        editor.apply();

    }

   public boolean isLoggedIn() {
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        return sharedPreferences.getBoolean("logged",false);


    }

    public User getUser(){

        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        return new User(sharedPreferences.getInt("userid",-1)
                ,sharedPreferences.getString("username",null)
                ,sharedPreferences.getString("email",null));

    }

    public void logout(){
        sharedPreferences=context.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);

        editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();

    }
}
