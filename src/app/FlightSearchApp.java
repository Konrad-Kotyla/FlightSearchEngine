package app;

import java.util.ArrayList;

public class FlightSearchApp {
    public static void main(String[] args) {
        FlightSearchControl flightSearchControl = new FlightSearchControl();
        flightSearchControl.checkIfFlightExists("Warszawa", "Londyn");
        flightSearchControl.displayFlightsFromCity("Londyn");
        flightSearchControl.displayFlightsToCity("Madryt");
        ArrayList<String> cities = flightSearchControl.getCities();
        System.out.println(cities);
        System.out.println(flightSearchControl.getCheapestFlight().getInfo());
        System.out.println(flightSearchControl.getCheapestFlightFromCity("Nowy Jork").getInfo());
        System.out.println(flightSearchControl.getFlights("Londyn", "Madryt"));
    }
}
