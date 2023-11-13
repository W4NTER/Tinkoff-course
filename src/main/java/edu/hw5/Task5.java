package edu.hw5;

public final class Task5 {
    private Task5() {
    }

    public static boolean plateValidation(String plate) {
        return plate.matches("^[АВЕКМНОРСТУХABEKMHOPCTYX]\\d{3}[АВЕКМНОРСТУХABEKMHOPCTYX]{2}\\d{2,3}$");
    }
}
