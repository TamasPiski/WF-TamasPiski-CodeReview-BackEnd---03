package citybike;

import java.time.LocalDateTime;

public class User {
    public static int userCount = 1;
    public int userId;
    public String sureName;
    public String lastName;
    public int currentlyRentedBike = 0;
    Rent rent;

    public User(String sureName, String lastName) {
        this.sureName = sureName;
        this.lastName = lastName;
        this.userId = userCount;
        userCount++;
    }

    public void rentBike(int bikeId) {
        System.out.println("");
        System.out.println("Renting process starts...");
        if (currentlyRentedBike == 0) {
            for (int key : Main.stations.keySet()) {
                for (int bikeIDonStation : Main.stations.get(key).bikesOnStation) {
                    if (bikeId == bikeIDonStation) {
                        if (Main.bikes.get(bikeId).setState(2)) {
                            Main.stations.get(key).bikesOnStation.remove((Integer) bikeId);
                            System.out.println("Bike nr." + bikeId + " successfully rented by user: " + lastName + " " + sureName +
                                    " and removed from station nr. " + Main.stations.get(key).stationID + ".");
                            currentlyRentedBike = bikeId;
                            this.rent = new Rent(this);
                            break;
                        }
                    }
                }
            }
            if (currentlyRentedBike == 0)
                System.out.println("Something went wrong, bike is not rented");
        } else
            System.out.println("Already rented a bike, cannot have two bikes at once");
        System.out.println("Renting process is finished.");
        System.out.println("");
    }

    public void returnBike(int bikeId, int stationId) {
        System.out.println("");
        System.out.println("Returning process starts...");
        if (bikeId == currentlyRentedBike) {
            if (Main.stations.get(stationId).addBike(bikeId)){
                currentlyRentedBike = 0;
                Main.bikes.get(bikeId).setState(0);
                rent.setRentEnd(LocalDateTime.now());
                System.out.println("Bike nr." + bikeId + " successfully returned by " + lastName + " " + sureName);
                rent.getRentlength();
            }
        } else
            System.out.println("Bike nr." + bikeId + " is not being rented by " + lastName + " " + sureName +
                    ", cannot be returned.");
        System.out.println("Returning process is finished.");
        System.out.println("");
    }
}
