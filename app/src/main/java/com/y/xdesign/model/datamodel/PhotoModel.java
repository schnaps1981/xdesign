package com.y.xdesign.model.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoModel {
    @SerializedName("photo_id")
    private Integer photoId;

    @SerializedName("photo")
    private String photo;

    @SerializedName("prew")
    private String prew;

    @SerializedName("is_main_photo")
    private Boolean isMainPhoto;

    @SerializedName("verification")
    private Integer verification;

    @SerializedName("likes")
    private Integer likes;

    @SerializedName("is_liked")
    private Integer isLiked;

    public Integer getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPrew() {
        return prew;
    }

    public void setPrew(String prew) {
        this.prew = prew;
    }

    public Boolean getIsMainPhoto() {
        return isMainPhoto;
    }

    public void setIsMainPhoto(Boolean isMainPhoto) {
        this.isMainPhoto = isMainPhoto;
    }

    public Integer getVerification() {
        return verification;
    }

    public void setVerification(Integer verification) {
        this.verification = verification;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getIsLiked() {
        return isLiked;
    }

    public void setIsLiked(Integer isLiked) {
        this.isLiked = isLiked;
    }
}