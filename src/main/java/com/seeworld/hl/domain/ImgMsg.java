package com.seeworld.hl.domain;

public class ImgMsg {

    private int ImgId;
    private int ImgType;
    private String ImgTitle;
    private String ImgDesc;
    private byte[] ImgAssetName;
    private byte[] ImgResourceName;

    public void set(int ImgType,String ImgTitle,String ImgDesc,byte[] ImgAssetName,byte[] ImgResourceName)
    {
        this.ImgType=ImgType;
        this.ImgTitle=ImgTitle;
        this.ImgResourceName=ImgResourceName;
        this.ImgDesc=ImgDesc;
        this.ImgAssetName=ImgAssetName;
    }
    public int getImgId() {
        return ImgId;
    }

    public void setImgId(int imgId) {
        ImgId = imgId;
    }

    public int getImgType() {
        return ImgType;
    }

    public void setImgType(int imgType) {
        ImgType = imgType;
    }

    public String getImgTitle() {
        return ImgTitle;
    }

    public void setImgTitle(String imgTitle) {
        ImgTitle = imgTitle;
    }

    public String getImgDesc() {
        return ImgDesc;
    }

    public void setImgDesc(String imgDesc) {
        ImgDesc = imgDesc;
    }

    public byte[] getImgAssetName() {
        return ImgAssetName;
    }

    public void setImgAssetName(byte[] imgAssetName) {
        ImgAssetName = imgAssetName;
    }

    public byte[] getImgResourceName() {
        return ImgResourceName;
    }

    public void setImgResourceName(byte[] imgResourceName) {
        ImgResourceName = imgResourceName;
    }



}
