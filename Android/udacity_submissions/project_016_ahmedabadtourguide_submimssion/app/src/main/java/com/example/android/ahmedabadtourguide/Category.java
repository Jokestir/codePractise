package com.example.android.ahmedabadtourguide;


public class Category {

    public static final int HISTORICAL_PLACES = 1;
    public static final int CATEGORY_RESTAURANTS = 2;
    public static final int CATEGORY_OUTDOOR = 3;
    public static final int CATEGORY_MUSEUMS = 4;
    public static final int RELIGIOUS_PLACES = 5;

    private int type;
    private String name;
    private String description;
    private int iconResourceId;


    public Category(int type, String name, int iconResourceId) {
        this.type = type;
        this.name = name;
        this.iconResourceId = iconResourceId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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

    public int getIconResourceId() {
        return iconResourceId;
    }

    public void setIconResourceId(int iconResourceId) {
        this.iconResourceId = iconResourceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (type != category.type) return false;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + name.hashCode();
        return result;
    }
}
