package model;

public class Journey {
    private Flight first;
    private Flight second;

    public Journey(Flight first, Flight second) {
        this.first = first;
        this.second = second;
    }

    public Flight getFirst() {
        return first;
    }

    public void setFirst(Flight first) {
        this.first = first;
    }

    public Flight getSecond() {
        return second;
    }

    public void setSecond(Flight second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Lot na trasie " + first.getDeparture() + "-" + second.getArrival() + " z przesiadką w mieście "
                + first.getArrival() + ". Lączny koszt " + (first.getPrice() + second.getPrice()) + "zł";
    }
}
