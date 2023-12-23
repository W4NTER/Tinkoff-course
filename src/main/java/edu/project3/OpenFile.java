package edu.project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
}
