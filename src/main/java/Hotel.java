
import java.util.LinkedList;


public class Hotel {
    private LinkedList<Integer> rooms;
    private int countConsumers;
    private int countProducers;
    private int totalRequest;

    public int getTotalRequest() {
        return totalRequest;
    }

    public void setTotalRequest(int totalRequest) {
        this.totalRequest = totalRequest;
    }

    public Hotel(LinkedList<Integer> rooms, int countConsumers, int countProducers, int totalRequest) {
        this.rooms = rooms;
        this.countConsumers = countConsumers;
        this.countProducers = countProducers;
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

    Hotel(LinkedList<Integer> rooms, int countConsumers, int countProducers) {
        this.rooms = rooms;
        this.countConsumers = countConsumers;
        this.countProducers = countProducers;
    }

    void addRoom(int id) {
        rooms.add(id);
    }

    int receiveLastRoom() {
        return rooms.getLast();
    }

    int removeLastRoom() {
        return rooms.remove();
    }
}
