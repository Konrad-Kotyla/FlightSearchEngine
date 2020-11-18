public class Flight {
    private String departure;
    private String arrival;
    private int price;

    public Flight(String departure, String arrival, int price) {
        this.departure = departure;
        this.arrival = arrival;
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInfo() {
        return this.departure + "-" + this.arrival + ": " + price + "zł";
    }
}
