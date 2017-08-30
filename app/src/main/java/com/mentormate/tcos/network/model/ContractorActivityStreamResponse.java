package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ContractorActivityStreamResponse {
    @SerializedName("Results")
    @Expose
    public List<ContractorStreamCard> Results = new ArrayList<>();
    @SerializedName("PagingOptions")
    @Expose
    public PagingOptions pagingOptions;


    public List<ContractorStreamCard> getResults() {
        return Results;
    }

    public void setResults(List<ContractorStreamCard> results) {
        Results = results;
    }

    public PagingOptions getPagingOptions() {
        return pagingOptions;
    }

    public void setPagingOptions(PagingOptions pagingOptions) {
        this.pagingOptions = pagingOptions;
    }


    @Override
    public String toString() {
        return "ContractorActivityStreamResponse{" +
                "Results=" + Results +
                ", pagingOptions=" + pagingOptions +
                '}';
    }
}
