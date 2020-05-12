package com.java.sky.entity;

/**
 * @author Sky
 * @date 2020/05/12
 */
public class User {

    private int id;
    private String userName;
    private int userAge;
    private String userAddress;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getuserAddress() {
        return userAddress;
    }

    public void setuserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    @Override
    public String toString() {
        return this.userName + " " + this.userAge + " " + this.userAddress;
    }

}
