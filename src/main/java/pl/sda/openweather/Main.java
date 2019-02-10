package pl.sda.openweather;


import javafx.application.Application;

import java.util.Scanner;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main  extends Application {
    public static void main(String[] args) {


//        WeatherService weatherService = new WeatherService(
//                "http://api.apixu.com/v1/current.json",
//                "705dc215140747bbaba91901191002"
//        );
//        String city;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Miasto: ");
//        while (!(city = scanner.nextLine()).equals("")) {
//            weatherService.getCityWeather(city);
//            System.out.println("Nastepne: ");
//        }
        launch(args);
    }
        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader
                    .load(getClass()
                            .getResource("/root.fxml"));

            primaryStage.setScene(new Scene(root, 600,350));
            primaryStage.show();

    }
}