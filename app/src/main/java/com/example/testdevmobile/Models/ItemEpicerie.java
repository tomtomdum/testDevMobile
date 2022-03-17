package com.example.testdevmobile.Models;

public class ItemEpicerie {
    private String nomItem;

    public ItemEpicerie(String nomItem, String descriptionItem) {
        this.nomItem = nomItem;
        this.descriptionItem = descriptionItem;
    }

    public String getNomItem() {
        return nomItem;
    }

    public void setNomItem(String nomItem) {
        this.nomItem = nomItem;
    }

    public String getDescriptionItem() {
        return descriptionItem;
    }

    public void setDescriptionItem(String descriptionItem) {
        this.descriptionItem = descriptionItem;
    }

    private String descriptionItem;


}
