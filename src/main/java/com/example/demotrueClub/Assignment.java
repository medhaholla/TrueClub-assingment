package com.example.demotrueClub;

import java.security.Timestamp;

public class Assignment {
    int id;
    String name;
    String address;
    int pincode;
    String state;
    Timestamp row_creation_timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Timestamp getRow_creation_timestamp() {
        return row_creation_timestamp;
    }

    public void setRow_creation_timestamp(Timestamp row_creation_timestamp) {
        this.row_creation_timestamp = row_creation_timestamp;
    }

    public Assignment (String name, int pincode, String address,String state) {
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.state = state;
    }
}
