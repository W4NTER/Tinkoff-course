package edu.hw9.Task1;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatsCollector {
    private final static Logger LOGGER = LogManager.getLogger();
    private final ConcurrentMap<String, double[]> metrics;

    public StatsCollector() {
        this.metrics = new ConcurrentHashMap<>();
    }

    public void push(String metricName, double[] data) {
        metrics.put(metricName, data);
    }

    public List<Metric> stats() {
        return metrics
            .entrySet()
            .stream()
            .map(e -> new Metric(e.getKey(), e.getValue()))
            .collect(Collectors.toList());
    }
}
