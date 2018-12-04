import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.Random;


public class Hotel {
    private LinkedList<Integer> rooms;
    private LinkedList<BookingRequest> requests;
    private int countConsumers;
    private int countProducers;
    private int totalRequest;

    public int getTotalRequest() {
        return totalRequest;
    }

    public LinkedList<BookingRequest> getRequests() {
        return requests;
    }

    public void setRequests(LinkedList<BookingRequest> requests) {
        this.requests = requests;
    }

    public void setTotalRequest(int totalRequest) {
        this.totalRequest = totalRequest;
    }

    public Hotel(LinkedList<BookingRequest> requests, int totalRequest) {
        this.requests = requests;
        this.totalRequest = totalRequest;
    }

    public LinkedList<Integer> getRooms() {
        return rooms;
    }

    public void setRooms(LinkedList<Integer> rooms) {
        this.rooms = rooms;
    }

    public int getCountConsumers() {
        return countConsumers;
    }

    public void setCountConsumers(int countConsumers) {
        this.countConsumers = countConsumers;
    }

    public int getCountProducers() {
        return countProducers;
    }

    public void setCountProducers(int countProducers) {
        this.countProducers = countProducers;
    }

    public void addRequest(BookingRequest bookingRequest) {
        requests.addLast(bookingRequest);
    }

    public BookingRequest removeLastRequest() {
        return requests.removeLast();
    }


    public void produce() throws InterruptedException {
        int value = 0;

        while (getTotalRequest() > 0) {

            BookingRequest bookingRequest = new BookingRequest(new Random().nextInt(15), LocalDateTime.now());
            synchronized (this) {
                if (getRequests().size() < 5) {
                    System.out.println(Thread.currentThread().getName() + " produced-" + value);
                    addRequest(bookingRequest);
                    notify();
                } else {
                    System.out.println(Thread.currentThread().getName() + " stack is full");
                    wait();
                }
            }
        }
    }

    public void consume() throws InterruptedException {

        while (getTotalRequest() > 0) {
            synchronized (this) {
                if (getRequests().isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " stack is empty");
                    wait();
                } else {
                    while (!getRequests().isEmpty()) {
                        //synchronized (this) {
                        //int val = removeLastRoom();
                        //System.out.println(Thread.currentThread().getName() + " consumed-" + val);
                        BookingRequest bookingRequest = removeLastRequest();
                        System.out.println(Thread.currentThread().getName() + " consumed-" + bookingRequest);
                        int localTotal = getTotalRequest() - 1;
                        setTotalRequest(localTotal);
                        Thread.sleep(1000);
                        notify();
                    }
                }
            }


        }
    }
}
