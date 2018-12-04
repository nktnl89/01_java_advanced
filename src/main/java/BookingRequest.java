import java.time.LocalDateTime;

public class BookingRequest {
    private int id;
    private LocalDateTime date;

    public BookingRequest(int id, LocalDateTime date) {
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "BookingRequest " + id + "    " + date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
