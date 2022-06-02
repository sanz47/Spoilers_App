package com.example.vallagtesena;

public class UserHelperClass
{
    String full_name;
    String email;
    String password;

    public UserHelperClass() {

    }


    public UserHelperClass(String full_name, String email, String password) {
        this.full_name = full_name;
        this.email = email;
        this.password = password;
    }

    public String getFname() {
        return full_name;
    }

    public void setFname(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
