package com.capgemini.hotel.model;

public class AllLists {
    private int id;
    private String listType;
    private String listItemName;

    public AllLists() {
    }

    public AllLists(int id, String listType, String listItemName) {
        this.id = id;
        this.listType = listType;
        this.listItemName = listItemName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListType() {
        return listType;
    }

    public void setListType(String listType) {
        this.listType = listType;
    }

    public String getListItemName() {
        return listItemName;
    }

    public void setListItemName(String listItemName) {
        this.listItemName = listItemName;
    }
}
