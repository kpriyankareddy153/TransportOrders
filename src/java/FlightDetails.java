import java.util.HashMap;

public class FlightDetails {

  int capacity = 20;
  static HashMap<String, HashMap<Integer, Integer>> map = new HashMap<String, HashMap<Integer, Integer>>();

  public FlightDetails() {}

  public FlightDetails(int capacity, HashMap<String, HashMap<Integer, Integer>> map1) {
    this.capacity = capacity;
    map = map1;
  }

  public static void initialize_map() {

    map.put("YYZ", new HashMap<Integer, Integer>() {
      {
        put(1, 1);
        put(2, 4);
      }
    });
    map.put("YYC", new HashMap<Integer, Integer>() {
      {
        put(1, 2);
        put(2, 5);
      }
    });
    map.put("YVR", new HashMap<Integer, Integer>() {
      {
        put(1, 3);
        put(2, 6);
      }
    });

  }

  public int get_flights_capacity() {
    return this.capacity;
  }

  public static HashMap<String, HashMap<Integer, Integer>> get_flights_data() {
    return map;
  }

  public static void main(String[] args) {
    System.out.println("Flight details class....");
    initialize_map();
    HashMap<String, HashMap<Integer, Integer>> default_map = get_flights_data();
    System.out.println("Mappings of HashMap default_map are : "+ default_map);
  }
  
}
