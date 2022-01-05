package ru.skillbox;

public class House {
    private int countHome;
    private int countFrontDoor;
    private double houseCondition;
    private int countPeople;

    public House(String streetHome, int countHome) {
        this.countHome = countHome;
    }

    public int getCountFrontDoor() {
        return countFrontDoor;
    }

    public void setCountFrontDoor(int countFrontDoor) {
        this.countFrontDoor = countFrontDoor;
    }

    public double getHouseCondition() {
        return houseCondition;
    }

    public void setHouseCondition(double houseCondition) {
        this.houseCondition = houseCondition;
    }

    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }
}
