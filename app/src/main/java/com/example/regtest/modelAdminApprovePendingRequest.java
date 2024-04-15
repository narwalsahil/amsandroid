package com.example.regtest;

public class modelAdminApprovePendingRequest {

    String id;
    String name;

    public modelAdminApprovePendingRequest(String id, String name, String username, String address, String gender, String mobile, String email, String institution) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.institution = institution;
    }

    String username;
    String address;
    String gender;
    String mobile;
    String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    String institution;

}
