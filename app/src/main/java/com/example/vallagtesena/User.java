package com.example.vallagtesena;

public class User {
    private String email1;
    private String password1;
    private String firstName;
    private String lastName;
    public User() {
    }
    public User(String email1,String password1){
        this.email1=email1;
        this.password1=password1;
    }

    public User(String email1, String password1, String firstName, String lastName) {
        this.email1 = email1;
        this.password1 = password1;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
