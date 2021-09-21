package com.example.buspass;

public class model_2 {
    String company, model, variant, year, color, kmdriven, owner, state, city, price, description;

    public model_2(String company, String model, String variant, String year, String color, String kmdriven, String owner, String state, String city, String price, String description) {
        this.company = company;
        this.model = model;
        this.variant = variant;
        this.year = year;
        this.color = color;
        this.kmdriven = kmdriven;
        this.owner = owner;
        this.state = state;
        this.city = city;
        this.price = price;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getKmdriven() {
        return kmdriven;
    }

    public void setKmdriven(String kmdriven) {
        this.kmdriven = kmdriven;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
