package com.seeworld.hl.domain;

public class ImgMsg {

    private int ImgId;
    private int ImgType;
    private String ImgTitle;
    private String ImgDesc;
    private Byte[] ImgAssetName;
    private Byte[] ImgResourceName;

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

    public Byte[] getImgAssetName() {
        return ImgAssetName;
    }

    public void setImgAssetName(Byte[] imgAssetName) {
        ImgAssetName = imgAssetName;
    }

    public Byte[] getImgResourceName() {
        return ImgResourceName;
    }

    public void setImgResourceName(Byte[] imgResourceName) {
        ImgResourceName = imgResourceName;
    }



}
