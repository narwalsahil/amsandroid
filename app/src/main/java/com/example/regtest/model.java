package com.example.regtest;

public class model {
    String name;
    String username;

    public model(String name, String username, String password, String status, String address, String gender, String mobile, String email, String institute, String otp) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.status = status;
        this.address = address;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.institute = institute;
        this.otp = otp;
    }

    String password;
    String status;
    String address;
    String gender;
    String mobile;
    String email;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    String institute;
    String otp;


}