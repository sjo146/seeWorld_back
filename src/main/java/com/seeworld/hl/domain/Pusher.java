package com.seeworld.hl.domain;

public class Pusher {
    int PId;
    String PUsername;
    String PName;
    String PPwd;
    String PDesc;
    String PPhone;

    public String getPUsername() {
        return PUsername;
    }

    public void setPUsername(String PUsername) {
        this.PUsername = PUsername;
    }

    public String getPPhone() {
        return PPhone;
    }

    public void setPPhone(String PPhone) {
        this.PPhone = PPhone;
    }
    public int getPId() {
        return PId;
    }

    public String getPName() {
        return PName;
    }

    public String getPDesc() {
        return PDesc;
    }

    public String getPPwd() {
        return PPwd;
    }

    public void setPDesc(String PDesc) {
        this.PDesc = PDesc;
    }

    public void setPId(int PId) {
        this.PId = PId;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public void setPPwd(String PPwd) {
        this.PPwd = PPwd;
    }
    public void set(String PName,String PPwd,String PPhone,String PDesc,String PUsername)
    {
        this.PDesc=PDesc;
        this.PName=PName;
        this.PPhone=PPhone;
        this.PPwd=PPwd;
        this.PUsername=PUsername;
    }

}
