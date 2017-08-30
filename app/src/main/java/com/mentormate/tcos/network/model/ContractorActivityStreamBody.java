package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContractorActivityStreamBody {
    @SerializedName("PagingOptions")
    @Expose
    private PagingOptions pagingOptions;
    @SerializedName("SortOrder")
    @Expose
    private int sortOrder;
    @SerializedName("Entity")
    @Expose
    private Entity entity;

    public PagingOptions getPagingOptions() {
        return pagingOptions;
    }

    public void setPagingOptions(PagingOptions pagingOptions) {
        this.pagingOptions = pagingOptions;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "ContractorActivityStreamBody{" +
                "pagingOptions=" + pagingOptions +
                ", sortOrder=" + sortOrder +
                ", entity=" + entity +
                '}';
    }
}
