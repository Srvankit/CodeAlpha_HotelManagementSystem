import java.io.FileWriter;
import java.time.LocalDateTime;

public class BookingLogger {

    public void save(String text) {

        try (

            FileWriter writer =

            new FileWriter(

            "data/bookings.txt",

            true)

        ) {

            writer.write(

            "["

            + LocalDateTime.now()

            + "] "

            + text

            + "\n");

            writer.write(

            "-----------------------------------\n");
        }

        catch (Exception e) {

            System.out.println(

            "Unable to save booking history.");
        }
    }
}