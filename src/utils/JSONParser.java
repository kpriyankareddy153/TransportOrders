package src.utils;

import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JSONParser {

//    Method to parse JSON Data present in file and return the Object
    public static Object parse_JSON_Data() {
        org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
        Object obj = null;
        try {
            obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/files/coding-assigment-orders.json"));
        } catch (IOException | ParseException e) {
            System.out.println("File not found");
        }
        return obj;
    }
}
