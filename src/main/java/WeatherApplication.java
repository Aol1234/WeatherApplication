import GUI.GUI;
import REST_API.OpenWeatherClass;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.junit.Assert;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class WeatherApplication {
    static String api_key = "228a5cc907ac1238f45c6c7528f7f2cc";
    public String Tf = "";

    public WeatherApplication() {
        GUI g = new GUI();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        WeatherApplication w = new WeatherApplication();
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}