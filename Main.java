package com.company;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        createVehicles();
        simulateRace();
        printRaceResults();

    }

    private static ArrayList<Car> createdCars = new ArrayList<>();
    private static ArrayList<Truck> createdTrucks = new ArrayList<>();
    private static ArrayList<Motorcycle> createdMotorcycles = new ArrayList<>();


    private static boolean probabilityOfBreakdown(){
        boolean isBreakdown;
        int breakdownChance = ThreadLocalRandom.current().nextInt(0, 100);
        if (breakdownChance < 6) {
            isBreakdown =  true;
        } else {
            isBreakdown = false;
        }
        return isBreakdown;
    }

    private static boolean probabilityOfRain(){
        boolean isRaining;
        int rainingChance = ThreadLocalRandom.current().nextInt(0, 100);
        if (rainingChance < 31) {
            isRaining =  true;
        } else {
            isRaining = false;
        }
        return isRaining;
    }

    private static void createVehicles() {
        for (int i = 0; i < 10; i++) {
            Car racingCars = new Car();
            createdCars.add(racingCars);
            Truck racingTrucks = new Truck();
            createdTrucks.add(racingTrucks);
            Motorcycle racingMotorcycles = new Motorcycle();
            createdMotorcycles.add(racingMotorcycles);
        }
    }


    private static void simulateRace() {

        for (int round=0; round < 50; round++) {

            boolean roundRaining = probabilityOfRain();
            for (Car racingCar : createdCars ) {
                if (roundRaining) {
                    racingCar.setSpeedLimit(70);
                } else {
                    racingCar.setSpeedLimit(racingCar.getNormalSpeed());
                }
                racingCar.moveForAnHour();
            }

            for (Motorcycle racingMotorcycles: createdMotorcycles) {
                if (roundRaining) {
                    racingMotorcycles.setSpeedLimit(racingMotorcycles.calculateRainySpeed());
                } else {
                    racingMotorcycles.setSpeedLimit(racingMotorcycles.getNormalSpeed());
                }

                racingMotorcycles.moveForAnHour();
            }

            for (Truck racingTruck: createdTrucks) {
                if (racingTruck.getBreakdownTurnsLeft() == 0) {
                    boolean roundBreakdown = probabilityOfBreakdown();
                    if (roundBreakdown) {
                        racingTruck.setBreakdownTurnsLeft(2); // 2 hours breakdown
                    } else {
                        racingTruck.setBreakdownTurnsLeft(0); // no breakdown
                    }
                }
                racingTruck.moveForAnHour();
            }
        }

    }



    public static void printRaceResults(){

        System.out.println("RACE RESULT:");

        for (Car racingCar : createdCars ) {
            System.out.println(racingCar.getName() + " from " + racingCar.getType() + " class is travelled " + racingCar.getDistanceTraveled() + " km.");
        }
        for (Motorcycle racingMotorcycle : createdMotorcycles ) {
            System.out.println(racingMotorcycle.getName() + " from " + racingMotorcycle.getType() + " class is travelled " + racingMotorcycle.getDistanceTraveled() + " km.");
        }
        for (Truck racingTruck : createdTrucks ) {
            System.out.println(racingTruck.getName() + " from " + racingTruck.getType() + " class is travelled " + racingTruck.getDistanceTraveled() + " km.");
        }
    }

}



