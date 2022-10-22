package src.java;

import java.util.HashMap;

public class UserStory1 {

//  Method to iterate through the flight data map and print the data in required fashion
  public static void print_flight_data() {
    FlightDetails.initialize_flights_data();
    HashMap<Integer, HashMap<String, Integer>> map = FlightDetails.get_flights_data();

    String departure = FlightDetails.get_flights_departure();
    for (Integer flight : map.keySet())
    {
        HashMap<String, Integer> destinationDayMap = map.get(flight);
        for (String destination : destinationDayMap.keySet()) {
          System.out.println("Flight: " + flight + ", departure: " + departure + ", arrival: " + destination + ", day: " + destinationDayMap.get(destination));
        }
    }
  }

  public static void main(String[] args) {
    print_flight_data();
  }
}
