package pl.sda.openweather.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WeatherService {

    private String finalURL ="http://api.apixu.com/v1/current.json?key=eb0dab1bfa244a84ad090225191002&q=";
    private String url;
    private String apiKey;

    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;

    }


    public void getCityWeather(String city)  {

        try {
            URL jsonURL = new URL(finalURL + city);

            ObjectMapper objectMapper = new ObjectMapper();
            Weather weather = objectMapper.readValue(jsonURL, Weather.class);
            System.out.println( weather.getLocation().getName() + " - "
                    + weather.getCurrent().getTemp_c() + " C");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "WeatherService{" +
                "finalURL='" + finalURL + '\'' +
                ", url='" + url + '\'' +
                ", apiKey='" + apiKey + '\'' +
                '}';
    }
}