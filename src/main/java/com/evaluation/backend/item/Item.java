package com.evaluation.backend.item;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity (name = "item")
public class Item {
    protected Item(){

    }

    @Id
    @GeneratedValue
    private long itemId;

    @Size(min = 1)
    private String itemName;

    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "item_location_id")
    private Location location;

    // Constructor

    public Item(long itemId, String itemName, String description, Location location) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.description = description;
        this.location = location;
    }

    // Getters and Setters

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    // toString

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", description='" + description + '\'' +
                ", location=" + location +
                '}';
    }
}

