package staticResources;

import model.Flight;
import model.Journey;

import java.util.ArrayList;

public class FlightDatabase {
    private ArrayList<Flight> flights = new ArrayList<>();

    public FlightDatabase() {
        flights.add(new Flight("Warszawa", "Londyn", 319));
        flights.add(new Flight("Londyn", "Warszawa", 289));
        flights.add(new Flight("Warszawa", "Nowy Jork", 1749));
        flights.add(new Flight("Nowy Jork", "Warszawa", 2099));
        flights.add(new Flight("Londyn", "Nowy Jork", 1359));
        flights.add(new Flight("Londyn", "Paryż", 279));
        flights.add(new Flight("Paryż", "Madryt", 189));
        flights.add(new Flight("Nowy Jork", "Londyn", 1279));
        flights.add(new Flight("Warszawa", "Madryt", 409));
        flights.add(new Flight("Madryt", "Warszawa", 329));
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<Flight> flights) {
        this.flights = flights;
    }
}