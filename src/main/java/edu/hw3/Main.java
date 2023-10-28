package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) {
        LOGGER.info(Task1.atbash("Hello world!"));
        LOGGER.info((char) 89);

    }
}
