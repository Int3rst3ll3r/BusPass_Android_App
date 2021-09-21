package com.example.buspass;

public class PassRate_Model {

    private String Bus_Name;

    public String getBus_Name() {
        return Bus_Name;
    }

    public void setBus_Name(String bus_Name) {
        Bus_Name = bus_Name;
    }

    public int getBus_Image() {
        return Bus_Image;
    }

    public void setBus_Image(int bus_Image) {
        Bus_Image = bus_Image;
    }

    public PassRate_Model(String bus_Name, int bus_Image) {
        Bus_Name = bus_Name;
        Bus_Image = bus_Image;
    }

    private int Bus_Image;
}
