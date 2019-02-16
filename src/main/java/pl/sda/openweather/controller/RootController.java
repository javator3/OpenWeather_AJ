package pl.sda.openweather.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.sda.openweather.model.Weather;
import pl.sda.openweather.model.WeatherService;


public class RootController implements Initializable {

    private String finalURL ="http://api.apixu.com/v1/current.json?key=8e42af245b4240d7bc192407191002&q=";


    @FXML
    private Button search;

    @FXML
    private TextField city;

    @FXML
    private Label temp;

    @FXML
    private Label feelTemp;

    @FXML
    private Label realResult;

    @FXML
    private Label feelResult;

    @FXML
    private ImageView weatherImage;

    public void initialize(URL location, ResourceBundle resources) {
        city.setText("nazwa miasta ");

    }

    public void setCity(ActionEvent actionEvent) {


        URL jsonURL = null;
        try {
            jsonURL = new URL(finalURL+ city.getText());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        Weather weather = null;
        try {
            weather = objectMapper.readValue(jsonURL, Weather.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        realResult.setText(String.valueOf(weather.getCurrent().getTemp_c()));
        feelResult.setText(String.valueOf(weather.getCurrent().getFeelslike_c()));

        Image image = new Image("http:" + weather.getCurrent().getCondition().getIcon());

        weatherImage.setImage(image);

    }
}