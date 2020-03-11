package com.y.xdesign.model.datamodel;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhotoModel implements Parcelable {
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

    protected PhotoModel(Parcel in) {
        if (in.readByte() == 0) {
            photoId = null;
        } else {
            photoId = in.readInt();
        }
        photo = in.readString();
        prew = in.readString();
        byte tmpIsMainPhoto = in.readByte();
        isMainPhoto = tmpIsMainPhoto == 0 ? null : tmpIsMainPhoto == 1;
        if (in.readByte() == 0) {
            verification = null;
        } else {
            verification = in.readInt();
        }
        if (in.readByte() == 0) {
            likes = null;
        } else {
            likes = in.readInt();
        }
        if (in.readByte() == 0) {
            isLiked = null;
        } else {
            isLiked = in.readInt();
        }
    }

    public static final Creator<PhotoModel> CREATOR = new Creator<PhotoModel>() {
        @Override
        public PhotoModel createFromParcel(Parcel in) {
            return new PhotoModel(in);
        }

        @Override
        public PhotoModel[] newArray(int size) {
            return new PhotoModel[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        if (photoId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(photoId);
        }
        parcel.writeString(photo);
        parcel.writeString(prew);
        parcel.writeByte((byte) (isMainPhoto == null ? 0 : isMainPhoto ? 1 : 2));
        if (verification == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(verification);
        }
        if (likes == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(likes);
        }
        if (isLiked == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(isLiked);
        }
    }
}