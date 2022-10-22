package src.java;

import org.json.simple.JSONObject;
import java.util.HashMap;
import java.util.TreeMap;

import static src.utils.JSONParser.parse_JSON_Data;

public class UserStory2 {
    public static HashMap<Integer, HashMap<String, Integer>> flightsData;
    public static HashMap<Integer, Integer> flightDetailsWithCapacity = new HashMap<Integer, Integer>();

//    Method to initialize a map with flight and capacity information to allow easy parsing
//    This function sets the flightDetailsWithCapacity like {flight_number: capacity}
    private static void initializeFlightDetailsWithCapacity(){
        FlightDetails.initialize_flights_data();
        flightsData = FlightDetails.get_flights_data();
        for (Integer flight : flightsData.keySet()){
            flightDetailsWithCapacity.put(flight, FlightDetails.get_flights_capacity());
        }
    }

//    This function takes orders as inputs and iterates through the flight data to check if there exists a destination matching order destination
//    If Yes, Print the data adjusting the corresponding flight capacity
//    In No, Print that there is no flight Scheduled
    private static void validateAndPrintItineraries(String order, String order_destination){
        String departure = FlightDetails.get_flights_departure();
        boolean destination_found = false;
        for (Integer flight : flightsData.keySet()) {
            HashMap<String, Integer> destinationDayMap = flightsData.get(flight);
            
            for (String destination : destinationDayMap.keySet()) {
                if(destination.equals(order_destination)){
                    if(flightDetailsWithCapacity.get(flight) == null) continue;
                    else if (flightDetailsWithCapacity.get(flight) == 1) flightDetailsWithCapacity.remove(flight);
                    else flightDetailsWithCapacity.replace(flight, flightDetailsWithCapacity.get(flight) - 1);
                    System.out.println("order: " + order + " , flightNumber: " + flight + " , departure: "
                            + departure + " , arrival: " + destination + " , day: "
                            + flightsData.get(flight).get(destination));
                    destination_found = true;
                    return;
                }
            }
        }
        if(destination_found == false) {
          System.out.println("order: " + order + " , flightNumber: not scheduled");
        }
    }


    public static void main(String args[]){
        JSONObject jsonObject = (JSONObject)parse_JSON_Data();
        initializeFlightDetailsWithCapacity();
        TreeMap<String,String> orders = new TreeMap<String, String>();
        for (Object key : jsonObject.keySet()) {
            if (jsonObject.get(key) instanceof JSONObject) {
                JSONObject order = (JSONObject) jsonObject.get(key);
                orders.put((String) key, (String) order.get("destination"));
            }
        }
        for (String order_id : orders.keySet()) {
            validateAndPrintItineraries(order_id, orders.get(order_id));
        }
    }
}
