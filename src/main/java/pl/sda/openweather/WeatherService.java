package pl.sda.openweather;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.openweather.model.Weather;
import java.io.IOException;
import java.net.URL;

public class WeatherService {
    private String url;
    private String apiKey;
    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }

    public void getCityWeather(String City)
    {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            URL urltmp = new URL(url + "?key="+apiKey+"&q="+City);
            Weather weather =  objectMapper.readValue(urltmp, Weather.class);
            System.out.println("Pogoda : " + City +weather.getCurrent().getTemp_c());


        } catch (IOException e) {
            System.out.println("nie mozna probrac "+ City);
        }



    }


}