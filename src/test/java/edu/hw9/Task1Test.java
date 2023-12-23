package edu.hw9;

import edu.hw9.Task1.Metric;
import edu.hw9.Task1.StatsCollector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    @DisplayName("Провекрка значений выходящего листа")
    void testThatFindMaxValueFromOutputReturnedSucceed() {
        StatsCollector collector = new StatsCollector();

        collector.push("metric_name", new double[] {0.1, 0.05, 1.4, 5.1, 0.3});
        collector.push("name2", new double[] {0.1, 0.01, 1.4, 5.1, 9.3});

        final List<Metric> EXPECTED_VALUE = List.of(
            new Metric("metric_name", new double[] {0.1, 0.05, 1.4, 5.1, 0.3}),
            new Metric("name2", new double[] {0.1, 0.01, 1.4, 5.1, 9.3}));
        assertEquals(EXPECTED_VALUE.get(0).getMax(), collector.stats().get(0).getMax());
        assertEquals(EXPECTED_VALUE.get(1).getAverage(), collector.stats().get(1).getAverage());
    }
}
