package com.example.ticket.types.jacksonPojos;

public class UserPojo extends AccountPojo{
    private String email;
    private String name;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
