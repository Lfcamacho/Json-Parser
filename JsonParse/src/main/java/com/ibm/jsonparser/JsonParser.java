package com.ibm.jsonparser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
   
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();

        try {        
            URL url = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1");
            URLConnection connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            
            JSONObject json = (JSONObject) parser.parse(in);
            JSONArray data = (JSONArray) json.get("data");
            
            for (Object o : data) {
            	JSONObject movie = (JSONObject) o;
                String title = (String) movie.get("Title");
                System.out.println("Title : " + title);
            }
           
            in.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }  
    }  
}

