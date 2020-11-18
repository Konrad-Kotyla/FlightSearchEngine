import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FlightDatabase database = new FlightDatabase();
        database.checkIfFlightExists("Warszawa", "Londyn");
        database.displayFlightsFromCity("Londyn");
        database.displayFlightsToCity("Madryt");
        ArrayList<String> cities = database.getCities();
        System.out.println(cities);
        System.out.println(database.getCheapestFlight().getInfo());
        System.out.println(database.getCheapestFlightFromCity("Nowy Jork").getInfo());
    }
}
