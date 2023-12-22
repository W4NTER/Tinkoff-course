package edu.hw6.Task5;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class HackerNews {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static String TOP_STORIES_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private final static String ITEM_URL = "https://hacker-news.firebaseio.com/v0/item/%d.json";
    private final static int SUCCESSFUL_CONNECT = 200;
    private final static int TITLE_GROUP = 1;

    private final HttpClient httpClient;

    public HackerNews() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public long[] hackerNewsTopStories() throws IOException, InterruptedException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(TOP_STORIES_URL))
                .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return arrOfStories(response);
        } catch (Exception e) {
            return new long[0];
        }
    }

    public static long[] arrOfStories(HttpResponse<String> response) {
        if (response.statusCode() == SUCCESSFUL_CONNECT) {
            String json = response.body();
            String[] ids = json.replaceAll("[\\[\\]]", "").split(",");
            return Arrays.stream(ids)
                .mapToLong(Long::parseLong)
                .toArray();
        } else {
            return new long[0];
        }
    }

    public String news(long id) throws InterruptedException {
        try (HttpClient httpClient = HttpClient.newHttpClient()) {
            String url = String.format(ITEM_URL, id);
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            return getTitle(response);
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return "Unknown";
    }

    public static String getTitle(HttpResponse<String> response) {
        if (response.statusCode() == SUCCESSFUL_CONNECT) {
            String json = response.body();
            Pattern pattern = Pattern.compile("\"title\":\"([^\"]+)\"");
            Matcher matcher = pattern.matcher(json);
            if (matcher.find()) {
                return matcher.group(TITLE_GROUP);
            }
        }
        return "";
    }
}
