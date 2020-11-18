import java.util.ArrayList;

public class FlightDatabase {
    private ArrayList<Flight> flights = new ArrayList<>();

    public FlightDatabase() {
        flights.add(new Flight("Warszawa", "Londyn", 319));
        flights.add(new Flight("Londyn", "Warszawa", 289));
        flights.add(new Flight("Warszawa", "Nowy Jork", 1749));
        flights.add(new Flight("Nowy Jork", "Warszawa", 2099));
        flights.add(new Flight("Londyn", "Nowy Jork", 1359));
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
}
