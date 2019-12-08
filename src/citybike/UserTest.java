package citybike;

import org.testng.annotations.AfterTest;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @AfterTest
    void rentBike() {
        Bike bike = new Bike("Red");
        User user = new User("Tamas", "Piski");
        Station station = new Station("Westbahnhof");
        station.addBike(1);
        assertTrue(station.bikesOnStation.contains(1), "Should be true if bike is still on the station");
        assertEquals(0, user.currentlyRentedBike, "User should have the bikeID of 0 hence not renting any bikes yet");
        assertEquals(2, bike.getState(), "Bike should be in CanBeRented state ");
        user.rentBike(1);
        assertFalse(station.bikesOnStation.contains(1),"Should be false hence bike is already rented by the user");
        assertEquals(1, user.currentlyRentedBike, "User should have the bikeID of the rented bike");
        assertEquals(2, bike.getState(), "Bike should be in In service state ");
    }

    @org.junit.jupiter.api.Test
    void returnBike() {
        Bike bike = new Bike("Red");
        User user = new User("Tamas", "Piski");
        Station station = new Station("Westbahnhof");
        station.addBike(1);
        user.rentBike(1);
        assertFalse(station.bikesOnStation.contains(1), "Should be true since bike is being rented and not on the station");
        assertEquals(1, user.currentlyRentedBike, "User should have the bikeID 1 before returning the bike");
        assertEquals(2, bike.getState(), "Bike should be in InService state ");
        user.returnBike(1, 1);
        assertTrue(station.bikesOnStation.contains(1), "Should be true if bike is returned to the station");
        assertEquals(0, user.currentlyRentedBike, "User should have the bikeID 0 after returning the bike");
        assertEquals(0, bike.getState(), "Bike should be in CanBeRented state ");
    }
}