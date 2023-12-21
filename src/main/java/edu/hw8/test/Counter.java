package edu.hw8.test;

public class Counter {

    public Double count(double a) {
        for (int i = 0; i < 10; i++) {
            a = a + Math.tan(a);
            System.out.println("a");
        }

        return a;
    }
}
