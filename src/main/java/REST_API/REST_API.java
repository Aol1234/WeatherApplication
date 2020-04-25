package REST_API;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class REST_API {

    public static void main(String[] args) throws IOException, InterruptedException {

    }

    public String QueryApi(String query) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.openweathermap.org/data/2.5/forecast?q=" + query + "&mode=json&appid=228a5cc907ac1238f45c6c7528f7f2cc"))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        assert response != null;
        /*System.out.println(response.body());*/

        return response.body();
    }
}
