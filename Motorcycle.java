package com.company;


import java.util.concurrent.ThreadLocalRandom;

public class Motorcycle {
    /*// speed is 100km/h. If rains, travels with 5-50km/h slower (randomly).
    static nameNumber // The number of the instance created. Used for its name.
            name // Are called "Motorcycle 1", "Motorcycle 2", "Motorcycle 3",... Unique.
    distanceTraveled
    moveForAnHour()*/

    private String name;
    private static int nameNumber = 1;
    private String type;
    private int normalSpeed;
    private int maxSpeed = 150; // if raining (30% chance) will be set to small random number by set speed limit
    private int distanceTraveled;


    public Motorcycle() {
        this.name = "Motorcycle " + nameNumber;

        this.type = "Motorcycle";

        this.normalSpeed = 100;

        this.distanceTraveled = 0;

        nameNumber++;
    }

    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


    public int getNormalSpeed() {
        return normalSpeed;
    }


    public int getDistanceTraveled() {
        return distanceTraveled;
    }


    public int calculateRainySpeed() {
        int rainySpeed = ThreadLocalRandom.current().nextInt(50, 95);
        return rainySpeed;
    }


    public void setSpeedLimit(int limit) {
        maxSpeed = limit;
    }


    public void moveForAnHour() {
        int currentSpeed = Math.min(maxSpeed, normalSpeed);
        distanceTraveled = distanceTraveled + currentSpeed;
    }
}