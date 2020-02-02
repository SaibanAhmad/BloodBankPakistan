package com.example.bloodbankpakistan;

public class ApiModel {


    private String userName;

    private int userAge;

    private String eMailId;

    private int userContactNo;

    private String userAddress;

    private String userPassword;


    public ApiModel(String userName, int userAge, String eMailId, int userContactNo, String userAddress, String userPassword) {
        this.userName = userName;
        this.userAge = userAge;
        this.eMailId = eMailId;
        this.userContactNo = userContactNo;
        this.userAddress = userAddress;
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public String geteMailId() {
        return eMailId;
    }

    public int getUserContactNo() {
        return userContactNo;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public String getUserPassword() {
        return userPassword;
    }
}


