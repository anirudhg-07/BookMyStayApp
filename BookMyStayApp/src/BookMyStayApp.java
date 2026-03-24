import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}

class Room {
    private String type;
    private int beds;
    private int size;
    private double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}

class RoomService {
    private RoomInventory inventory;

    public RoomService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void showAvailability() {
        Room single = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suite = new Room("Suite", 3, 750, 5000.0);

        display(single);
        display(doubleRoom);
        display(suite);
    }

    private void display(Room room) {
        Map<String, Integer> availabilityMap = inventory.getRoomAvailability();
        int available = availabilityMap.get(room.getType());

        if (available > 0) {
            System.out.println(room.getType() + " Room:");
            System.out.println("Beds: " + room.getBeds());
            System.out.println("Size: " + room.getSize() + " sqft");
            System.out.println("Price per night: " + room.getPrice());
            System.out.println("Available: " + available);
            System.out.println();
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        RoomService service = new RoomService(inventory);
        service.showAvailability();
    }
}