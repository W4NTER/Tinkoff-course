package edu.hw6.Task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final static Logger LOGGER = LogManager.getLogger();
    private final File file;

    public DiskMap(String filePath) {
        this.file = new File(filePath);
    }

    public Map<String, String> readMap() {
        Map<String, String> map = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] elements = line.split(":");
                if (elements.length == 2) {
                    map.put(elements[0], elements[1]);
                }
            }
            reader.close();
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
        return map;
    }

    private void saveMap(Map<String, String> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Map.Entry<String, String> el : map.entrySet()) {
                writer.write(el.getKey() + ":" + el.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            LOGGER.info(e.getMessage());
        }
    }

    @Override
    public int size() {
        return readMap().size();
    }

    @Override
    public boolean isEmpty() {
        return readMap().isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return readMap().containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return readMap().containsValue(value);
    }

    @Override
    public String get(Object key) {
        return readMap().get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        Map<String, String> map = readMap();
        String prev = map.put(key, value);
        saveMap(map);
        return prev;
    }

    @Override
    public String remove(Object key) {
        Map<String, String> map = readMap();
        String removedValue = map.remove(key);
        saveMap(map);
        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        Map<String, String> map = readMap();
        map.putAll(m);
        saveMap(map);
    }

    @Override
    public void clear() {
        saveMap(new HashMap<>());
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return readMap().keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return readMap().values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return readMap().entrySet();
    }
}
