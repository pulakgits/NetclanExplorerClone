package com.basetechz.netclanexplorerclone.Models;

public class model {
    String name,image,city,distance,purposeCoffee,purposeBusiness,purposeHobbies,purposeFriendShip,purposeMovies,purposeDinning,purposeDating,
    purposeMatrimony, hiCommunity,Bio,UserId;

    public model(){

    }

    public model(String name, String image, String city, String distance, String purposeCoffee, String purposeBusiness, String purposeHobbies, String purposeFriendShip, String purposeMovies, String purposeDinning, String purposeDating, String purposeMatrimony, String hiCommunity, String bio, String userId) {
        this.name = name;
        this.image = image;
        this.city = city;
        this.distance = distance;
        this.purposeCoffee = purposeCoffee;
        this.purposeBusiness = purposeBusiness;
        this.purposeHobbies = purposeHobbies;
        this.purposeFriendShip = purposeFriendShip;
        this.purposeMovies = purposeMovies;
        this.purposeDinning = purposeDinning;
        this.purposeDating = purposeDating;
        this.purposeMatrimony = purposeMatrimony;
        this.hiCommunity = hiCommunity;
        this.Bio = bio;
        this.UserId = userId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getPurposeCoffee() {
        return purposeCoffee;
    }

    public void setPurposeCoffee(String purposeCoffee) {
        this.purposeCoffee = purposeCoffee;
    }

    public String getPurposeBusiness() {
        return purposeBusiness;
    }

    public void setPurposeBusiness(String purposeBusiness) {
        this.purposeBusiness = purposeBusiness;
    }

    public String getPurposeHobbies() {
        return purposeHobbies;
    }

    public void setPurposeHobbies(String purposeHobbies) {
        this.purposeHobbies = purposeHobbies;
    }

    public String getPurposeFriendShip() {
        return purposeFriendShip;
    }

    public void setPurposeFriendShip(String purposeFriendShip) {
        this.purposeFriendShip = purposeFriendShip;
    }

    public String getPurposeMovies() {
        return purposeMovies;
    }

    public void setPurposeMovies(String purposeMovies) {
        this.purposeMovies = purposeMovies;
    }

    public String getPurposeDinning() {
        return purposeDinning;
    }

    public void setPurposeDinning(String purposeDinning) {
        this.purposeDinning = purposeDinning;
    }

    public String getPurposeDating() {
        return purposeDating;
    }

    public void setPurposeDating(String purposeDating) {
        this.purposeDating = purposeDating;
    }

    public String getPurposeMatrimony() {
        return purposeMatrimony;
    }

    public void setPurposeMatrimony(String purposeMatrimony) {
        this.purposeMatrimony = purposeMatrimony;
    }

    public String getHiCommunity() {
        return hiCommunity;
    }

    public void setHiCommunity(String hiCommunity) {
        this.hiCommunity = hiCommunity;
    }

    public String getBio() {
        return Bio;
    }

    public void setBio(String bio) {
        Bio = bio;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
