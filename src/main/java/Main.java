import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(new LinkedList<BookingRequest>(), 15);

        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        hotel.produce();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "producer " + i).start();
        }

        for (int i = 0; i < 6; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        hotel.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer " + i).start();
        }


    }
}


