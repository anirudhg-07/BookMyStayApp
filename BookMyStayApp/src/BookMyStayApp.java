public class BookMyStayApp {

        static abstract class Room {
            protected int numberOfBeds;
            protected int squareFeet;
            protected double pricePerNight;

            public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
                this.numberOfBeds = numberOfBeds;
                this.squareFeet = squareFeet;
                this.pricePerNight = pricePerNight;
            }

            public void displayRoomDetails() {
                System.out.println("Beds: " + numberOfBeds);
                System.out.println("Size: " + squareFeet + " sqft");
                System.out.println("Price per night: " + pricePerNight);
                System.out.println("Available: true");
            }
        }

        static class SingleRoom extends Room {
            public SingleRoom() {
                super(1, 250, 1500.0);
            }
        }

        static class DoubleRoom extends Room {
            public DoubleRoom() {
                super(2, 400, 2000.0);
            }
        }

        static class SuiteRoom extends Room {
            public SuiteRoom() {
                super(3, 750, 5000.0);
            }
        }

        public static void main(String[] args) {
            System.out.println("Hotel Room Initialization");

            System.out.println("\nSingle Room:");
            Room single = new SingleRoom();
            single.displayRoomDetails();

            System.out.println("\nDouble Room:");
            Room doubleRoom = new DoubleRoom();
            doubleRoom.displayRoomDetails();

            System.out.println("\nSuite Room:");
            Room suite = new SuiteRoom();
            suite.displayRoomDetails();
        }
    }


