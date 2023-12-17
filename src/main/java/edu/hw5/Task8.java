package edu.hw5;

public final class Task8 {
    private Task8() {}

    private final static int PAT1 = 1;
    private final static int PAT2 = 2;
    private final static int PAT3 = 3;
    private final static int PAT4 = 4;
    private final static int PAT5 = 5;
    private final static int PAT6 = 6;
    private final static int PAT7 = 7;

    public static boolean regularExpressions(int pattern, String input) {
        boolean m = switch (pattern) {
            case (PAT1) -> input.matches("^([01][01])*[01]$");
            case (PAT2) -> input.matches("^(0([01][01])*[01]|1([01][01]{2}))*$");
            case (PAT3) -> input.matches("^(1*01*01*01*)*$");
            case (PAT4) -> input.matches("^(?!11$)(?!111$)[01]+$");
            case (PAT5) -> input.matches("^(1[01])*1?$");
            case (PAT6) -> input.matches("^(?=(.*0){2})(?!.*1.*1)[01]+$");
            case (PAT7) -> input.matches("^(?![01]*11)[01]+$");
            default -> false;
        };
        return m;
    }
}
