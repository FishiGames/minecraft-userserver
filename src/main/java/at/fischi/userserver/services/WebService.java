package at.fischi.userserver.services;

import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;

@Service
public class WebService {

    @SneakyThrows
    public String getRequest(String urlName) {
        var stringBuilder = new StringBuilder();
        var url = URI.create(urlName).toURL();
        var httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        try (var bufferedReader = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }
}
