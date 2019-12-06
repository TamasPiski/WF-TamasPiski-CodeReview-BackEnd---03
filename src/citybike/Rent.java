package citybike;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rent {
    int pricePerHour = 10;
    int bikeID = 0;
    User user;
    LocalDateTime rentStart;
    private LocalDateTime rentEnd;

    public Rent(User user) {
        this.user = user;
        this.rentStart = LocalDateTime.now();
        this.bikeID = user.currentlyRentedBike;
    }


    public LocalDateTime getRentEnd() {
        return rentEnd;
    }

    public void setRentEnd(LocalDateTime rentEnd) {
        this.rentEnd = rentEnd;
    }

    public void getRentlength() {
        Duration duration = Duration.between(rentStart, rentEnd);
        System.out.println();
        System.out.println("Summary of bike tracking:");
        System.out.println("User " + user.lastName + " " + user.sureName + " rented the bike nr." + bikeID);
        System.out.println("Length of rent: " + String.format("%02d:%02d:%02d",duration.toHoursPart(), duration.toMinutesPart(),
                duration.toSecondsPart()));
        System.out.println("This rent costs:" + (duration.toHours()*pricePerHour) + " EUR");
    }
}
