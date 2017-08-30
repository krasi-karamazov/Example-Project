package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContractorStreamCard {
    @SerializedName("ActivityId")
    @Expose
    public String аctivityId;
    @SerializedName("OriginId")
    @Expose
    public String оriginId;
    @SerializedName("Origin")
    @Expose
    public Origin оrigin;
    @SerializedName("Producer")
    @Expose
    public Producer producer;
    @SerializedName("Timestamp")
    @Expose
    public String timestamp;
    @SerializedName("ContentType")
    @Expose
    public String contentType;
    @SerializedName("Content")
    @Expose
    public JobCardContent content;
    @SerializedName("MessageStreamType")
    @Expose
    public String messageStreamType;
    @SerializedName("HashCode")
    @Expose
    public int hashCode;

    public String getАctivityId() {
        return аctivityId;
    }

    public void setАctivityId(String аctivityId) {
        this.аctivityId = аctivityId;
    }

    public String getОriginId() {
        return оriginId;
    }

    public void setОriginId(String оriginId) {
        this.оriginId = оriginId;
    }

    public Origin getОrigin() {
        return оrigin;
    }

    public void setОrigin(Origin оrigin) {
        this.оrigin = оrigin;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public JobCardContent getContent() {
        return content;
    }

    public void setContent(JobCardContent content) {
        this.content = content;
    }

    public String getMessageStreamType() {
        return messageStreamType;
    }

    public void setMessageStreamType(String messageStreamType) {
        this.messageStreamType = messageStreamType;
    }

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    @Override
    public String toString() {
        return "ContractorStreamCard{" +
                "аctivityId='" + аctivityId + '\'' +
                ", оriginId='" + оriginId + '\'' +
                ", оrigin=" + оrigin +
                ", producer=" + producer +
                ", timestamp='" + timestamp + '\'' +
                ", contentType='" + contentType + '\'' +
                ", content=" + content +
                ", messageStreamType='" + messageStreamType + '\'' +
                ", hashCode=" + hashCode +
                '}';
    }
}
