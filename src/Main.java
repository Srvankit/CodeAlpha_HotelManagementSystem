import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hotel hotel = new Hotel();

        Reservation reservation = new Reservation();

        SessionStats stats = new SessionStats();

        BookingLogger logger = new BookingLogger();

        UI.showBanner();

        while (true) {

            UI.showMenu();

            System.out.print(

            "Choose option : ");

            int choice =

            sc.nextInt();

            if (choice == 1) {

                hotel.showRooms();
            }

            else if (choice == 2) {

                sc.nextLine();

                System.out.print(

                "Enter category : ");

                String category =

                sc.nextLine();

                hotel.searchRoom(

                category);
            }

            else if (choice == 3) {

                sc.nextLine();

                System.out.print(

                "Enter customer name : ");

                String customerName =

                sc.nextLine();

                System.out.print(

                "Enter room number : ");

                int roomNumber =

                sc.nextInt();

                Room room =

                hotel.findRoom(

                roomNumber);

                if (room == null) {

                    System.out.println(

                    "\nRoom unavailable.\n");
                }

                else {

                    room.setAvailable(

                    false);

                    Customer customer =

                    new Customer(

                    customerName);

                    reservation

                    .addReservation(

                    customer.getName(),

                    room.getRoomNumber(),

                    room.getCategory(),

                    room.getPrice());

                    stats.increaseBookings();

                    logger.save(

                    "Booked Room "

                    + roomNumber

                    + " by "

                    + customerName);

                    System.out.println(

                    "\nRoom booked successfully.\n");
                }
            }

            else if (choice == 4) {

                reservation

                .showReservations();
            }

            else if (choice == 5) {

                System.out.print(

                "Enter room number : ");

                int roomNumber =

                sc.nextInt();

                boolean cancelled =

                reservation

                .cancelReservation(

                roomNumber);

                if (cancelled) {

                    stats.increaseCancelled();

                    logger.save(

                    "Cancelled Room "

                    + roomNumber);

                    System.out.println(

                    "\nReservation cancelled.\n");
                }

                else {

                    System.out.println(

                    "\nReservation not found.\n");
                }
            }

            else if (choice == 6) {

                System.out.println();

                System.out.println(

                "PAYMENT SUMMARY");

                System.out.println(

                "---------------------------------------------------");

                System.out.println(

                "Total Amount : ₹"

                + Math.round(

                reservation

                .getTotalAmount()));

                System.out.println();
            }

            else if (choice == 7) {

                System.out.println();

                System.out.println(

                "SESSION SUMMARY");

                System.out.println(

                "---------------------------------------------------");

                System.out.println(

                "Bookings Made : "

                + stats.getBookingsMade());

                System.out.println(

                "Bookings Cancelled : "

                + stats.getBookingsCancelled());

                System.out.println(

                "Current Reservations : "

                + reservation

                .getCurrentReservations());

                UI.showExit();

                break;
            }

            else {

                System.out.println(

                "\nInvalid option.\n");
            }
        }

        sc.close();
    }
}