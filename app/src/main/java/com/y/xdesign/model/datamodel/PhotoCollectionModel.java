package com.y.xdesign.model.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollectionModel {
    @SerializedName("photos")
    private ArrayList<PhotoModel> photos = null;
    @SerializedName("error")

    private Integer error;

    public ArrayList<PhotoModel> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<PhotoModel> photos) {
        this.photos = photos;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }
}
