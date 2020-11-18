package app;

import model.Flight;
import model.Journey;
import staticResources.FlightDatabase;

import java.util.ArrayList;

public class FlightSearchControl {
    FlightDatabase flightDatabase = new FlightDatabase();
    ArrayList<Flight> flights = flightDatabase.getFlights();

    public void checkIfFlightExists(String start, String end) {
        for (Flight flight : this.flights) {
            String departure = flight.getDeparture();
            String arrival = flight.getArrival();

            if (departure.equals(start) && (arrival.equals(end))) {
                System.out.println("Lot: " + start + "-" + arrival + " znajduje się w naszej bazie.");
                return;
            }
        }
        System.out.println("Takie połączenie nie istnieje w naszej bazie lotów.");
    }

    private ArrayList<Flight> getFlightsFromCity(String city) {
        ArrayList<Flight> results = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (city.equals(flight.getDeparture())) {
                results.add(flight);
            }
        }
        return results;
    }

    private ArrayList<Flight> getFlightsToCity(String city) {
        ArrayList<Flight> results = new ArrayList<>();
        for (Flight flight : this.flights) {
            if (city.equals(flight.getArrival())) {
                results.add(flight);
            }
        }
        return results;
    }

    private void displayFlights(ArrayList<Flight> results) {
        if (results.isEmpty()) {
            System.out.println("Brak lotów o podanych kryteriach");
        } else {
            for (int i = 0; i < results.size(); i++) {
                Flight flight = results.get(i);
                System.out.println(flight.getInfo());
            }
        }
    }

    public void displayFlightsFromCity(String city) {
        ArrayList<Flight> results = getFlightsFromCity(city);
        displayFlights(results);
    }

    public void displayFlightsToCity(String city) {
        ArrayList<Flight> results = getFlightsToCity(city);
        displayFlights(results);
    }

    public ArrayList<String> getCities() {
        ArrayList<String> cities = new ArrayList<>();
        for (Flight flight : this.flights) {
            String departureCity = flight.getDeparture();
            String arrivalCity = flight.getArrival();
            if (!cities.contains(departureCity)) {
                cities.add(departureCity);
            }
            if (!cities.contains(arrivalCity)) {
                cities.add(arrivalCity);
            }
        }
        return cities;
    }

    public Flight getCheapestFlight() {
        Flight cheapestFlight = null;
        for (Flight flight : this.flights) {
            if (cheapestFlight == null || flight.getPrice() < cheapestFlight.getPrice())
                cheapestFlight = flight;
        }
        return cheapestFlight;
    }

    public Flight getCheapestFlightFromCity(String city) {
        Flight cheapestFlight = null;
        ArrayList<Flight> flightsFromCity = getFlightsFromCity(city);
        for (Flight flight : flightsFromCity) {
            if (cheapestFlight == null || flight.getPrice() < cheapestFlight.getPrice())
                cheapestFlight = flight;
        }
        return cheapestFlight;
    }

    public ArrayList<Journey> getFlights(String start, String end) {
        ArrayList<Journey> results = new ArrayList<>();
        ArrayList<Flight> starting = getFlightsFromCity(start);
        ArrayList<Flight> ending = getFlightsToCity(end);
        for (Flight first : starting)
            for (Flight second : ending) {
                if (first.getArrival().equals(second.getDeparture())) {
                    results.add(new Journey(first, second));
                }
            }
        return results;
    }
}
