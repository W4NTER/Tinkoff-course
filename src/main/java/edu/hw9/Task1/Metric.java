package edu.hw9.Task1;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Metric {
    private final double[] data;
    private final String metricName;
    private final Double sumVal;
    private final Double avg;
    private final Double min;
    private final Double max;

    public Metric(String metricName, double[] data) {
        this.metricName = metricName;
        this.data = data;
        this.sumVal = getSum();
        this.max = getMax();
        this.min = getMin();
        this.avg = getAverage();
    }

    public Double getMultiRes(Double lambda) {
        try {
            ExecutorService service = Executors.newFixedThreadPool(4);
            Future<Double> res = service.submit(() -> lambda);
            service.shutdown();
            return res.get();
        } catch (Exception e) {
            return 0.0;
        }
    }

    public Double getSum() {
        return getMultiRes(Arrays.stream(data).sum());
    }

    public Double getAverage() {
        return getMultiRes(Arrays.stream(data).sum() / data.length);
    }

    public Double getMin() {
        return getMultiRes(Arrays.stream(data).min().getAsDouble());
    }

    public Double getMax() {
        return getMultiRes(Arrays.stream(data).max().getAsDouble());
    }
}
