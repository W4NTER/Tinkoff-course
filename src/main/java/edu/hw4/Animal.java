package edu.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    private static final int PAWS_CAT_DOG = 4;
    private static final int PAWS_BIRD = 2;
    private static final int PAWS_FISH = 0;
    private static final int PAWS_SPIDER = 4;

    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    public int paws() {
        return switch (type) {
            case CAT, DOG -> PAWS_CAT_DOG;
            case BIRD -> PAWS_BIRD;
            case FISH -> PAWS_FISH;
            case SPIDER -> PAWS_SPIDER;
        };
    }
}
