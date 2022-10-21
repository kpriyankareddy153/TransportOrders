import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

public class UserStory1 extends FlightDetails {

  public void print_flight_data() {
    System.out.println("print_flight_data....");
    FlightDetails.initialize_map();
    HashMap<String, HashMap<Integer, Integer>> map = FlightDetails.get_flights_data();

    // FUnction to sort based on Flight numbers
    // Comparator<Entry<String, HashMap<Integer, Integer>>> valueComparator = new Comparator<Entry<String, HashMap<Integer, Integer>>>() { 
    //   // Entry<Integer, Integer> df = 
    //   @Override 
    //   public int compare(Entry<String, HashMap<Integer, Integer>> e1, Entry<String, HashMap<Integer, Integer>> e2) { 
    //     HashMap<Integer, Integer> v1 = e1.getValue(); 
    //     HashMap<Integer, Integer> v2 = e2.getValue(); 
    //     return v1.getValue().compareTo(v2.getValue()); 
    //   } };

    // Collections.sort(map, valueComparator);



    String departure = "YUL";
    for (String destination : map.keySet()) 
    {
        HashMap<Integer, Integer> day_flightno_map = map.get(destination);
        for (Integer day : day_flightno_map.keySet()) {
          System.out.println("Flight: " + day_flightno_map.get(day) + ", departure: " + departure + ", arrival: " + destination + ", day: " + day);
        }
    }
  }

  public static void main(String[] args) {
    System.out.println("UserStory1....");
    UserStory1 us1 = new UserStory1();
    us1.print_flight_data();
  }
}
