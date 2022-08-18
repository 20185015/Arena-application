package com.example.arena;

public class Category {
    private String id;
    private String name;
    private String description;
    private String price;
    private String favorite;
    private int image;

    public Category() {
    }

    public Category(String id, String name, String description, String price, String favorite, int image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.favorite = favorite;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
