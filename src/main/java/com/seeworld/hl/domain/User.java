package com.seeworld.hl.domain;

public class User {
    int UId;
    String UUsername;
    String UPassword;
    String UPersonal;

    public void setUPersonal(String UPersonal) {
        this.UPersonal = UPersonal;
    }

    public String getUPersonal() {
        return UPersonal;
    }

    public int getUId() {
        return UId;
    }

    public void setUId(int UId) {
        this.UId = UId;
    }

    public String getUUsername() {
        return UUsername;
    }

    public String getUPassword() {
        return UPassword;
    }

    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public void setUUsername(String UUsername) {
        this.UUsername = UUsername;
    }
}
