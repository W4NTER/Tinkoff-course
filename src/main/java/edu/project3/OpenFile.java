package edu.project3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.management.openmbean.OpenMBeanAttributeInfo;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class OpenFile {
    BufferedReader bufferedReader;
    private final static Logger LOGGER = LogManager.getLogger();

    OpenFile() {}

    public String[] readFile(String path) {
        List<String> res = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                res.add(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }
        String[] result = new String[res.size()];
        return res.toArray(result);
    }

    public static void main(String[] args) {
        OpenFile openFile = new OpenFile();
        String[] arr = openFile.readFile("src/main/resources/logs.txt");
        for (String a : arr) {
            System.out.println(a);
        }
    }
}
