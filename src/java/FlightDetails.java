package src.java;

import java.util.HashMap;

public class FlightDetails {

  public static final int capacity = 20;
  public static final String departure = "YUL";
  static HashMap<Integer, HashMap<String, Integer>> map = new HashMap<Integer, HashMap<String, Integer>>();

//  Method to initialize the flights data
  public static void initialize_flights_data() {

    map.put(1, new HashMap<String, Integer>() {{
        put("YYZ", 1);
    }});

    map.put(2, new HashMap<String, Integer>() {{
        put("YYC", 1);
    }});

    map.put(3, new HashMap<String, Integer>() {{
        put("YVR", 1);
    }});

    map.put(4, new HashMap<String, Integer>() {{
        put("YYZ", 2);
    }});

    map.put(5, new HashMap<String, Integer>() {{
        put("YYC", 2);
    }});

    map.put(6, new HashMap<String, Integer>() {{
        put("YVR", 2);
    }});

  }

  public static int get_flights_capacity() {
    return capacity;
  }

  public static String get_flights_departure() {
    return departure;
  }

  public static HashMap<Integer, HashMap<String, Integer>> get_flights_data() {
    return map;
  }

  public static void main(String[] args) {
    initialize_flights_data();
    HashMap<Integer, HashMap<String, Integer>> default_map = get_flights_data();
    System.out.println("Mappings of HashMap(default_map) are : "+ default_map);
  }
  
}
