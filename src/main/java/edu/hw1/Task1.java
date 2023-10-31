package edu.hw1;

public final class Task1 {
    private final static String SEPARATOR = ":";
    private final static int SECONDS_PER_MINUTE = 60;

    private Task1() {
    }

    public static int minutesToSeconds(String videoLength) throws NumberFormatException {
        try {
            String[] strSplit = videoLength.split(SEPARATOR);
            int minutes = Integer.parseInt(strSplit[0]);
            int seconds = Integer.parseInt(strSplit[1]);
            if (seconds >= SECONDS_PER_MINUTE) {
                return -1;
            } else {
                seconds = minutes * SECONDS_PER_MINUTE + seconds;
                return seconds;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
