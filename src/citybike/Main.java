package citybike;

import java.util.HashMap;

    public class Main {
        public static HashMap<Integer, Bike> bikes = new HashMap<>();
        public static HashMap<Integer, Station> stations = new HashMap<>();
        public static final HashMap<Integer, String> bikeStates = new HashMap<Integer, String>(){{
            put(0, "CanBeRented");
            put(1, "CanNotBeRented");
            put(2, "InService");
            put(3, "Discarded ");
        }};



    public static void main(String[] args) throws InterruptedException {

        // creating bikes
        Bike bike1 = new Bike("red");
        Bike bike2 = new Bike("red");
        Bike bike3 = new Bike("red");
        Bike bike4 = new Bike("red");
        Bike bike5 = new Bike("red");
        Bike bike6 = new Bike("red");
        Bike bike7 = new Bike("red");
        Bike bike8 = new Bike("blue");
        Bike bike9 = new Bike("blue");
        Bike bike10= new Bike("blue");


        //creating stations
        Station station1 = new Station("Westbahnhof");
        Station station2 = new Station("Hauptbahnhof");
        Station station3 = new Station("Erdberg");

       //adding bikes to stations using bike ID-s
        System.out.println("Adding bikes to the stations: ");
        station1.addBike(1);
        station1.addBike(2);
        station1.addBike(3);
        station2.addBike(4);
        station2.addBike(5);
        station2.addBike(6);
        station2.addBike(7);
        station3.addBike(8);
        station3.addBike(9);
        station3.addBike(10);

        //creating users
        User user1 = new User("Smith", "Peter");
        User user2 = new User("Carol", "Shelby");
        User user3 = new User("Ford", "Taylor");
        User user4 = new User("Obama", "Barack");

        //renting bikes using bike ID-s
        //user Smith rents bike Nr. 2 from station Nr. 1
        user1.rentBike(1);
        user1.rentBike(4);
        //waiting so the tracking makes sense
        waitForRent(5000);


        //returning bike by user Smith
        user1.returnBike(1, 2);

    }

    public static void waitForRent(int milliseconds) throws InterruptedException {
        System.out.print("Waiting for the user to return the bike");
        for (int i = 0; i < 5; i++) {
            System.out.print(".");
            Thread.sleep(milliseconds/5);
        }
        System.out.println();
    }
}
