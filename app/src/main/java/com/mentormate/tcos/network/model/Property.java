package com.mentormate.tcos.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Property {
    @SerializedName("User")
    @Expose
    public User user;
    @SerializedName("PropertyId")
    @Expose
    public String propertyId;
    @SerializedName("Image")
    @Expose
    public Image image;
    @SerializedName("Name")
    @Expose
    public String name;
    @SerializedName("Description")
    @Expose
    public String description;
    @SerializedName("Address")
    @Expose
    public String address;
    @SerializedName("Contacts")
    @Expose
    public List<Contact> contacts = new ArrayList<>();
    @SerializedName("IsArchived")
    @Expose
    public boolean isArchived;

    @SerializedName("OrganizationName")
    @Expose
    public String organizationName;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @Override
    public String toString() {
        return "Property{" +
                "user=" + user +
                ", propertyId='" + propertyId + '\'' +
                ", image=" + image +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", contacts=" + contacts +
                ", isArchived=" + isArchived +
                ", organizationName='" + organizationName + '\'' +
                '}';
    }
}
