package com.example.lab_1_2_raviradadiya_0836175_android.model;

public class ProductModel {
    int id;
    String name,descr;
    Double price;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescr() {
        return descr;
    }

    public Double getPrice() {
        return price;
    }

    public ProductModel(int id, String name, String descr, Double price) {
        this.id = id;
        this.name = name;
        this.descr = descr;
        this.price = price;
    }
}
