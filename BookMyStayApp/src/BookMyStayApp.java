import java.util.*;

class Reservation {
    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }
}

class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single", 2);
        inventory.put("Double", 2);
        inventory.put("Suite", 1);
    }

    public boolean isAvailable(String roomType) {
        return inventory.getOrDefault(roomType, 0) > 0;
    }

    public void reduce(String roomType) {
        inventory.put(roomType, inventory.get(roomType) - 1);
    }
}

class RoomAllocationService {
    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;
    private Map<String, Integer> counters;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
        counters = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        String type = reservation.getRoomType();

        if (!inventory.isAvailable(type)) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }

        String roomId = generateRoomId(type);

        allocatedRoomIds.add(roomId);
        assignedRoomsByType.putIfAbsent(type, new HashSet<>());
        assignedRoomsByType.get(type).add(roomId);

        inventory.reduce(type);

        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {
        int count = counters.getOrDefault(roomType, 0) + 1;
        counters.put(roomType, count);
        return roomType + "-" + count;
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomAllocationService service = new RoomAllocationService();
        RoomInventory inventory = new RoomInventory();

        System.out.println("Room Allocation Processing");

        Reservation r1 = new Reservation("Abhi", "Single");
        Reservation r2 = new Reservation("Subha", "Single");
        Reservation r3 = new Reservation("Vannathi", "Suite");

        service.allocateRoom(r1, inventory);
        service.allocateRoom(r2, inventory);
        service.allocateRoom(r3, inventory);
    }
}