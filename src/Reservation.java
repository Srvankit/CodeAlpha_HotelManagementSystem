import java.util.ArrayList;

public class Reservation {

    private ArrayList<String> bookings;

    private double totalAmount;

    public Reservation() {

        bookings = new ArrayList<>();

        totalAmount = 0;
    }

    public void addReservation(

            String customer,

            int roomNumber,

            String category,

            double price) {

        bookings.add(

        customer

        + " | Room "

        + roomNumber

        + " | "

        + category

        + " | ₹"

        + price);

        totalAmount += price;
    }

    public void showReservations() {

        System.out.println();

        System.out.println(

        "RESERVATIONS");

        System.out.println(

        "---------------------------------------------------");

        if (bookings.isEmpty()) {

            System.out.println(

            "No reservations found.");

            return;
        }

        for (String booking : bookings) {

            System.out.println(

            booking);
        }

        System.out.println();
    }

    public boolean cancelReservation(

            int roomNumber) {

        for (int i = 0;

             i < bookings.size();

             i++) {

            if (bookings.get(i)

            .contains(

            "Room "

            + roomNumber)) {

                bookings.remove(i);

                return true;
            }
        }

        return false;
    }

    public double getTotalAmount() {

        return totalAmount;
    }

    public int getCurrentReservations() {

        return bookings.size();
    }
}