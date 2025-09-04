package core;

import java.util.concurrent.ThreadLocalRandom;

public final class Dice {
    private Dice() {}
    public static int d6() { return ThreadLocalRandom.current().nextInt(1,7); }
    public static int d20(){ return ThreadLocalRandom.current().nextInt(1, 21); }
}