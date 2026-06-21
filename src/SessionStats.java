public class SessionStats {

    private int bookingsMade;

    private int bookingsCancelled;

    public SessionStats() {

        bookingsMade = 0;

        bookingsCancelled = 0;
    }

    public void increaseBookings() {

        bookingsMade++;
    }

    public void increaseCancelled() {

        bookingsCancelled++;
    }

    public int getBookingsMade() {

        return bookingsMade;
    }

    public int getBookingsCancelled() {

        return bookingsCancelled;
    }
}