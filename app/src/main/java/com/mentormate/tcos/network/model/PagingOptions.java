package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PagingOptions {
    @SerializedName("From")
    @Expose
    private int fromIndex;
    @SerializedName("Size")
    @Expose
    private int size;
    @SerializedName("Before")
    @Expose
    private String beforeDate;

    public int getFromIndex() {
        return fromIndex;
    }

    public void setFromIndex(int fromIndex) {
        this.fromIndex = fromIndex;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBeforeDate() {
        return beforeDate;
    }

    public void setBeforeDate(String beforeDate) {
        this.beforeDate = beforeDate;
    }

    @Override
    public String toString() {
        return "PagingOptions{" +
                "fromIndex=" + fromIndex +
                ", size=" + size +
                ", beforeDate='" + beforeDate + '\'' +
                '}';
    }
}
