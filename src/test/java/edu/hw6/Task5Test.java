package edu.hw6;

import edu.hw6.Task5.HackerNews;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task5Test {

    private final static int ID = 38577114;
    @Test
    @DisplayName("Проверка нахождения названия новости")
    void testThatTitleOfNewsReturnedSucceed() throws IOException, InterruptedException {
        HackerNews hackerNews = new HackerNews();

        String title = hackerNews.news(ID);

        final String EXPECTED_TITLE =
            "Cooler Master's Framework case gives your laptop a second life";
        assertEquals(EXPECTED_TITLE, title);
    }
}
