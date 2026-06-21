import java.util.ArrayList;

public class Hotel {

    private ArrayList<Room> rooms;

    public Hotel() {

        rooms = new ArrayList<>();

        loadRooms();
    }

    private void loadRooms() {

        rooms.add(

        new Room(

        101,

        "Standard",

        1500));

        rooms.add(

        new Room(

        102,

        "Standard",

        1500));

        rooms.add(

        new Room(

        201,

        "Deluxe",

        4000));

        rooms.add(

        new Room(

        202,

        "Deluxe",

        4000));

        rooms.add(

        new Room(

        301,

        "Suite",

        7000));
    }

    public void showRooms() {

        System.out.println();

        System.out.println(

        "AVAILABLE ROOMS");

        System.out.println(

        "---------------------------------------------------");

        for (Room room : rooms) {

            if (room.isAvailable()) {

                System.out.println(

                "Room "

                + room.getRoomNumber()

                + " | "

                + room.getCategory()

                + " | ₹"

                + room.getPrice());
            }
        }

        System.out.println();
    }

    public void searchRoom(

            String category) {

        boolean found = false;

        System.out.println();

        System.out.println(

        "SEARCH RESULT");

        System.out.println(

        "---------------------------------------------------");

        for (Room room : rooms) {

            if (room.getCategory()

            .equalsIgnoreCase(

            category)

            && room.isAvailable()) {

                found = true;

                System.out.println(

                "Room "

                + room.getRoomNumber()

                + " | ₹"

                + room.getPrice());
            }
        }

        if (!found) {

            System.out.println(

            "No room found.");
        }

        System.out.println();
    }

    public Room findRoom(

        int roomNumber) {

    for (Room room : rooms) {

        if (room.getRoomNumber()

        == roomNumber

        && room.isAvailable()) {

            return room;
        }
    }

    return null;
}

    public ArrayList<Room>

    getRooms() {

        return rooms;
    }
}