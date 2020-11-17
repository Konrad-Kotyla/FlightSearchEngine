public class Flight {
    public String departure;
    public String arrival;

    public Flight(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public String getInfo() {
        return "Flight from " + this.departure + " to " + this.arrival;
    }
}
