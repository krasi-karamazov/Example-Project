package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("MobileFullUrl")
    @Expose
    private String mobileFullUrl;
    @SerializedName("MobileThumbnailUrl")
    @Expose
    private String mobileThumbnailUrl;
    @SerializedName("OriginalUrl")
    @Expose
    private String originalUrl;
    @SerializedName("Latitude")
    @Expose
    private double latitude;
    @SerializedName("Longitude")
    @Expose
    private double longitude;
    @SerializedName("DateTaken")
    @Expose
    private String dateTaken;

    public String getMobileFullUrl() {
        return mobileFullUrl;
    }

    public void setMobileFullUrl(String mobileFullUrl) {
        this.mobileFullUrl = mobileFullUrl;
    }

    public String getMobileThumbnailUrl() {
        return mobileThumbnailUrl;
    }

    public void setMobileThumbnailUrl(String mobileThumbnailUrl) {
        this.mobileThumbnailUrl = mobileThumbnailUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDateTaken() {
        return dateTaken;
    }

    public void setDateTaken(String dateTaken) {
        this.dateTaken = dateTaken;
    }

    @Override
    public String toString() {
        return "Image{" +
                "mobileFullUrl='" + mobileFullUrl + '\'' +
                ", mobileThumbnailUrl='" + mobileThumbnailUrl + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", dateTaken='" + dateTaken + '\'' +
                '}';
    }
}
