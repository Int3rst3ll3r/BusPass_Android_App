package com.example.buspass.modelresponse;

public class User {

   int userid;
   String username,email;

    public User(int id, String username, String email) {
        this.userid = id;
        this.username = username;
        this.email = email;
    }

    public int getId() {
        return userid;
    }

    public void setId(int id) {
        this.userid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
