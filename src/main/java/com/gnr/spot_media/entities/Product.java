package com.gnr.spot_media.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String image;

    private String mobileImage;

    private String shortTitle;

    private String thumbnail;

    @ManyToMany(targetEntity = Location.class)
    private List<Location> locations;

    private Boolean available;

    public Product() {
        this.locations = new ArrayList<>();
    }

    public Product(String title, String description, String image, String mobileImage, String shortTitle, String thumbnail, List<Location> locations) {
        this.description = description;
        this.image = image;
        this.mobileImage = mobileImage;
        this.locations = locations;
        this.shortTitle = shortTitle;
        this.thumbnail = thumbnail;
        this.title = title;
        this.available = true;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMobileImage() {
        return mobileImage;
    }

    public String getImageUrl(boolean isMobile){
        if (isMobile && getMobileImage() != null){
            return getMobileImage();
        } else {
            return getImage();
        }
    }

    public void setMobileImage(String mobile_image) {
        this.mobileImage = mobile_image;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public void addLocation(Location location){
        this.locations.add(location);
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available)
    {
        this.available = available;
    }
}
