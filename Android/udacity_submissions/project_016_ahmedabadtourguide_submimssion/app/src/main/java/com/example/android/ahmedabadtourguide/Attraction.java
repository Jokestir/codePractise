package com.example.android.ahmedabadtourguide;


import java.io.Serializable;

public class Attraction implements Serializable {


    private String description;
    private String name;

    private CustomLocation location;

    private String websiteUrl;
    private String phoneNumber;

    private int imageResourceId;

    // has tobe constants defined in category class. religious,restaurant,outdoor etc.
    private int type;

    public Attraction(String name, CustomLocation location, int imageResourceId, int type) {
        this.name = name;
        this.location = location;
        this.imageResourceId = imageResourceId;
        this.type = type;
    }

    public Attraction(String name, String description, CustomLocation location, String websiteUrl, String phoneNumber, int imageResourceId, int type) {
        this.description = description;
        this.name = name;
        this.location = location;
        this.websiteUrl = websiteUrl;
        this.phoneNumber = phoneNumber;
        this.imageResourceId = imageResourceId;
        this.type = type;
    }

    public Attraction(String name, String description, CustomLocation location, int imageResourceId, int type) {
        this.description = description;
        this.name = name;
        this.location = location;
        this.websiteUrl = websiteUrl;
        this.imageResourceId = imageResourceId;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomLocation getLocation() {
        return location;
    }

    public void setLocation(CustomLocation location) {
        this.location = location;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attraction that = (Attraction) o;

        if (!name.equals(that.name)) return false;
        return location.equals(that.location);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }
}
