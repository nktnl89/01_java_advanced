
public class ProducerService implements Runnable {
    private volatile Hotel hotel;

    ProducerService(Hotel hotel) {
        this.hotel = hotel;
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (this) {
                while (hotel.getRooms().size() == 5) {
                    wait();
                }
                System.out.println("Producer produced-" + value);
                hotel.addRoom(value++);

                int totalRequest = hotel.getTotalRequest();
                hotel.setTotalRequest(totalRequest--);
                notify();
            }
        }
    }

    @Override
    public void run() {
        try {
            while (hotel.getTotalRequest() > 0) {
                produce();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
