package edu.hw3;

import edu.hw3.Task8.BackwardIterator;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Main {

    private Main() {
    }

    private final static Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {
        LOGGER.info(Task1.atbash("Hello world!"));
        LOGGER.info(Arrays.toString(Task2.clusterize("((())())(()(()()))")));
        LOGGER.info(Task4.convertToRoman(16));
    }
}
