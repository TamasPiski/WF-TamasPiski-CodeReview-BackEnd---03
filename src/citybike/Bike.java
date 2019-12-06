package citybike;

public class Bike {

    public static int bikeCount = 1;
    public int bikeId;
    public String color;
    private int state = 0;

    public Bike(String color) {
        this.bikeId = bikeCount;
        bikeCount++;
    }


    public int getState() {
        System.out.println("Bike state is: " + Main.bikeStates.get(state));
        return state;
    }

    public boolean setState(int stateTo) {
        if (this.state != 0 && stateTo == 2) {
            System.out.println("Bike nr." + bikeId + " cannot be rented because it is in the state: " + Main.bikeStates.get(state));
            return false;
        }
        else {
            System.out.println("Bike nr." + bikeId + " state is set to: " + Main.bikeStates.get(stateTo));
            this.state = stateTo;
            return true;
        }
    }
}
