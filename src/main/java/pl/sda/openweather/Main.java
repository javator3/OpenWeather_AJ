package pl.sda.openweather;


import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService(
                "http://api.apixu.com/v1/current.json",
                "705dc215140747bbaba91901191002"
        );
        String city ;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Miasto: ");
        while (!(city = scanner.nextLine()).equals("")) {
            weatherService.getCityWeather(city);
            System.out.println("Nastepne: ");
        }


    }
}