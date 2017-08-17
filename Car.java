package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Car {
    // Since cars are so fast there is a 30% chance that they can go only with 70km/h speed. ---- mainben lesz beállítva amikor a futam elindul
    //static setSpeedLimit(int limit) // Call this from the Main class!
    //normalSpeed // the normal speed of the car. Set to a random number in the constructor between 80-110km/h.
    // car name
    //distanceTraveled // holds the current distance traveled.
    //moveForAnHour() // The vehicle travels for an hour. It increases the distance traveled. Call this from the main class only!

    private ArrayList<String> carName = new ArrayList<>(Arrays.asList("Meridian", "Centurion", "Pulse", "Empyrean", "Flux", "Dynamics", "Eternity", "Surge", "Parallel", "Pinnacle"));
    private Random randomizer = new Random();
    private String[] name;
    private int normalSpeed;
    private int distanceTraveled;
    private int maxSpeed = 111;

    public int getNormalSpeed() {
        return normalSpeed;
    }

    public String[] getName() {
        return name;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }


    public Car (){
       String random1 = carName.get(randomizer.nextInt(carName.size()));
       String random2 = carName.get(randomizer.nextInt(carName.size()));
       this.name = new String[2];
       this.name[0] = random1;
       this.name[1] = random2;

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
