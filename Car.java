package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Car {

    private String name;
    private String type;
    private int normalSpeed;
    private int distanceTraveled;
    private int maxSpeed = 150; // now it is higher tnah the normal speed, if 30% chance will be set to 70 km/h


    public int getNormalSpeed() {
        return normalSpeed;
    }

    public String getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public String getType() {
        return type;
    }


    public Car (){
        ArrayList<String> carName = new ArrayList<>(Arrays.asList("Meridian", "Centurion", "Pulse", "Empyrean", "Flux", "Dynamics", "Eternity", "Surge", "Parallel", "Pinnacle"));
        Random randomizer = new Random();
        String random1 = carName.get(randomizer.nextInt(carName.size()));
        String random2 = carName.get(randomizer.nextInt(carName.size()));
        this.name = random1 + " " +random2;

        this.type = "Car";

        this.normalSpeed = ThreadLocalRandom.current().nextInt(80, 110);

        this.distanceTraveled = 0;
    }

    public void setSpeedLimit(int limit) {
        maxSpeed = limit;
    }


    public void moveForAnHour() {
        int currentSpeed = Math.min(maxSpeed, normalSpeed);
        distanceTraveled = distanceTraveled + currentSpeed;
    }
}
