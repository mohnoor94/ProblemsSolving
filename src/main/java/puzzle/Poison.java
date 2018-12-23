package puzzle;

import java.util.ArrayList;

/**
 * You have 100 bottles of soda, and exactly one is poisoned. You have 10 test strips which can be used to detect
 * poison. A single drop of poison will turn the test strip positive permanently.
 * You can put any number of drops on a test strip at once and you can reuse a test strip as many times as you'd like
 * (as long as the results are negative). However, you can only run tests once per day and it takes seven days to
 * return a result.
 * How would you figure out the poisoned bottle in as few days as possible.
 * ***
 * * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 6.10)
 */
public class Poison {

    private static final int STRIPS = 10;
    private static final int MAX_BOTTLES = 1024;

    public static void main(String[] args) {

        Bottle[] bottles = new Bottle[1000];

        test(bottles, 693);

        test(bottles, 25);

        test(bottles, 512);

        test(bottles, 0);
    }

    private static int getPoisonedBottle(Bottle[] bottles) {
        if (bottles.length > MAX_BOTTLES) return -1;

        ArrayList<ArrayList<Bottle>> strips = new ArrayList<>();
        for (int i = 0; i < STRIPS; i++) {
            strips.add(new ArrayList<>());
        }

        for (Bottle bottle : bottles) {
            dropStrips(bottle, strips);
        }

        return formNumber(strips);
    }

    private static void dropStrips(Bottle bottle, ArrayList<ArrayList<Bottle>> strips) {
        int id = bottle.id;
        int bit = 0;
        while (id != 0) {
            if ((id & 1) == 1) strips.get(bit).add(bottle);
            bit++;
            id >>= 1;
        }
    }

    private static int formNumber(ArrayList<ArrayList<Bottle>> strips) {
        int id = 0;

        for (int i = strips.size() - 1; i >= 0; i--) {
            ArrayList<Bottle> bottles = strips.get(i);
            id <<= 1;
            if (hasPoisonedBottle(bottles)) {
                id += 1;
            }
        }

        return id;
    }

    private static boolean hasPoisonedBottle(ArrayList<Bottle> bottles) {
        for (Bottle bottle : bottles) if (bottle.poisoned) return true;
        return false;
    }

    private static void test(Bottle[] bottles, int i) {
        init(bottles);
        bottles[i].poisoned = true;
        System.out.println(getPoisonedBottle(bottles));
    }

    private static void init(Bottle[] bottles) {
        for (int i = 0; i < bottles.length; i++) {
            bottles[i] = new Bottle(i);
        }
    }
}

class Bottle {
    int id;
    boolean poisoned;

    Bottle(int id) {
        this.id = id;
    }
}