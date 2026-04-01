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

class BookingRequestQueue {
    private Queue<Reservation> queue = new LinkedList<>();

    public synchronized void addRequest(Reservation r) {
        queue.add(r);
    }

    public synchronized Reservation getNextRequest() {
        return queue.poll();
    }
}

class RoomInventory {
    private Map<String, Integer> rooms = new HashMap<>();

    public RoomInventory() {
        rooms.put("Single", 2);
        rooms.put("Double", 2);
        rooms.put("Suite", 1);
    }

    public boolean allocateRoom(String roomType) {
        int count = rooms.getOrDefault(roomType, 0);
        if (count > 0) {
            rooms.put(roomType, count - 1);
            return true;
        }
        return false;
    }
}

class RoomAllocationService {
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {
        boolean success = inventory.allocateRoom(reservation.getRoomType());
        if (success) {
            System.out.println(Thread.currentThread().getName() + " booked " +
                    reservation.getRoomType() + " for " + reservation.getGuestName());
        } else {
            System.out.println(Thread.currentThread().getName() + " failed booking for " +
                    reservation.getGuestName());
        }
    }
}

class ConcurrentBookingProcessor implements Runnable {
    private BookingRequestQueue bookingQueue;
    private RoomInventory inventory;
    private RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue bookingQueue,
                                      RoomInventory inventory,
                                      RoomAllocationService allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        while (true) {
            Reservation reservation;

            synchronized (bookingQueue) {
                reservation = bookingQueue.getNextRequest();
            }

            if (reservation == null) {
                break;
            }

            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocationService = new RoomAllocationService();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Sudha", "Double"));
        bookingQueue.addRequest(new Reservation("Vamsi", "Suite"));
        bookingQueue.addRequest(new Reservation("Ravi", "Single"));

        Thread t1 = new Thread(new ConcurrentBookingProcessor(
                bookingQueue, inventory, allocationService));

        Thread t2 = new Thread(new ConcurrentBookingProcessor(
                bookingQueue, inventory, allocationService));

        t1.start();
        t2.start();
    }
}