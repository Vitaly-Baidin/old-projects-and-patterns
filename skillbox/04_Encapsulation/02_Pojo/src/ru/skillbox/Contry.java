package ru.skillbox;

public class Contry {
    private String nameCountry;
    private int numberPeople;
    private double squareContry;
    private String capitalCountry;
    private boolean outSea;

    public Contry(String nameCountry) {
        this.nameCountry = nameCountry;
    }

    public int getNumberPeople() {
        return numberPeople;
    }

    public double getSquareContry() {
        return squareContry;
    }

    public String getCapitalCountry() {
        return capitalCountry;
    }

    public boolean isOutSea() {
        return outSea;
    }

    public void setNumberPeople(int numberPeople) {
        this.numberPeople = numberPeople;
    }

    public void setSquareContry(double squareContry) {
        this.squareContry = squareContry;
    }

    public void setCapitalCountry(String capitalCountry) {
        this.capitalCountry = capitalCountry;
    }

    public void setOutSea(boolean outSea) {
        this.outSea = outSea;
    }
}
