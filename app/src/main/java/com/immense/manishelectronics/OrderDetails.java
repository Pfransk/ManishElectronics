package com.immense.manishelectronics;

public class OrderDetails {
    private String Region;
    private String Location;
    private String Username;
    public OrderDetails(){

    }


    public  OrderDetails(String Region,String Location,String Username){
        this.Region = Region;
        this.Location = Location;
        this.Username = Username;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
