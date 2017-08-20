package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Truck {
    private int speed;
    private int breakdownTurnsLeft;
    private int distanceTraveled;
    private String name;
    private String type;


    public Truck() {
        this.name = "" + ThreadLocalRandom.current().nextInt(0, 1000);

        this.type = "Truck";

        this.speed = 100;

        this.distanceTraveled = 0;

        this.breakdownTurnsLeft = 0;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }


    public void setBreakdownTurnsLeft(int breakdownHours) { // set from main - if  5% chance is happened: breakdownTurnsLeft= 2
        this.breakdownTurnsLeft = breakdownHours;
    }


    public void moveForAnHour(){
        if(breakdownTurnsLeft > 0){
            breakdownTurnsLeft--;
            distanceTraveled += 0;
        } else{
            distanceTraveled += speed;
        }
    }
}