package edu.project3;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OpenLink {
    private final HttpClient httpClient;
    private final static int STATUS_CODE = 200;

    OpenLink() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String[] openLink(String link) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(link))
                .build();

            HttpResponse<String> httpResponse = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return arrOfLogs(httpResponse);
        } catch (Exception e) {
            return new String[0];
        }
    }

    private String[] arrOfLogs(HttpResponse<String> httpResponse) {
        if (httpResponse.statusCode() == STATUS_CODE) {
            return httpResponse.body().split("\n");
        } else {
            return new String[0];
        }
    }
}
