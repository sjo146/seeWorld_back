package com.seeworld.hl.domain;

public class User {
    int UId;
    String UUsername;
    String UPwd;

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }

    public String getUPwd() {
        return UPwd;
    }

    public String getUUsername() {
        return UUsername;
    }

    public void setUPwd(String UPwd) {
        this.UPwd = UPwd;
    }

    public void setUUsername(String UUsername) {
        this.UUsername = UUsername;
    }
}
