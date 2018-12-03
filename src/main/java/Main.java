import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(new LinkedList<Integer>(), 6, 3, 15);
        //https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/
        ProducerService producerService = new ProducerService(hotel);
        ConsumerService consumerService = new ConsumerService(hotel);

        Thread thread1 = new Thread(producerService);
        Thread thread2 = new Thread(consumerService);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}


