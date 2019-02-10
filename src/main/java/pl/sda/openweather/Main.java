package pl.sda.openweather;


import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.openweather.model.Weather;
import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        try {
            URL jsonURL = new URL("https://api.apixu.com/v1/current.json?key=705dc215140747bbaba91901191002&q=Toru%C5%84");
            ObjectMapper objectMapper = new ObjectMapper();
            Weather weather =objectMapper.readValue(jsonURL, Weather.class);
            System.out.println(weather);
        } catch(IOException e) {
            e.printStackTrace();

        }

    }
}
