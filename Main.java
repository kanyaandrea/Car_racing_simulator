package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        /*static isRaining //30% chance of rain every hour
        createVehicles() // creates 10 cars, 10 trucks and 10 motorcycles
         // simulates the race by calling moveForAnHour() on every vehicle 50 times and setting whether its raining.
        printRaceResults() // prints each vehicle's name, distance traveled ant type.*/

        simulateRace();
        createVehicles();


    }

    private static ArrayList<Car> createdCars = new ArrayList<>();
    private static ArrayList<Truck> createdTrucks = new ArrayList<>();
    private static ArrayList<Motorcycle> createdMotorcycles = new ArrayList<>();

    public static void createVehicles() {
        for (int i = 0; i < 10; i++) {
            Car racingCars = new Car();
            createdCars.add(racingCars);
            Truck racingTrucks = new Truck();
            createdTrucks.add(racingTrucks);
            Motorcycle racingMotorcycles = new Motorcycle();
            createdMotorcycles.add(racingMotorcycles);
        }
    }


    public static void simulateRace() {

        for (int round=0; round < 50; round++) {
            for (Car racingCar : createdCars ) {
                int chance = ThreadLocalRandom.current().nextInt(0, 100);
                if (chance < 30) {
                    racingCar.setSpeedLimit(70);
                } else {
                    racingCar.setSpeedLimit(racingCar.getNormalSpeed());
                }

                racingCar.moveForAnHour();
            }
        }
    }

    public static void printRaceResults(){

    }

}



