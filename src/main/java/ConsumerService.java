
public class ConsumerService implements Runnable {
    private volatile Hotel hotel;

    public ConsumerService(Hotel hotel) {
        this.hotel = hotel;
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {

                while (hotel.getRooms().isEmpty()) {
                    wait();
                }
                int val = hotel.removeLastRoom();

                System.out.println("Consumer consumed-" + val);

                notify();
                Thread.sleep(1000);
            }
        }
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
