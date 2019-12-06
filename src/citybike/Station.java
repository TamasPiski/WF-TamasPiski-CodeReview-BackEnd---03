package citybike;

import java.util.ArrayList;
import java.util.List;

public class Station {
    public static int stationCount= 1;
    public int stationID;
    public String location;
    public List<Integer> bikesOnStation =  new ArrayList<>();

    public Station(String location) {
        this.location = location;
        this.stationID = stationCount;
        stationCount++;
    }

    public boolean addBike(int bikeId) {
        if (bikesOnStation.size() == 5) {
            System.out.println("Maximum bikes at station, cannot add more");
            return false;
        }else {
            bikesOnStation.add(bikeId);
            System.out.println("Bike Nr." + bikeId + " added to station Nr." + this.stationID);
            return true;
        }
    }

}
