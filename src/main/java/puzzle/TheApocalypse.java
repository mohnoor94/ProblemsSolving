package puzzle;

import java.util.Random;

/**
 * In the new post-apocalyptic world, the world queen is desperately concerned about the birth rate. Therefore, she
 * decrees that al families should ensure that they have one girl or else they face massive fines. If all families
 * abide by this policy - that is, they have continue to have children until they have one girl, at which point they
 * immediately stop - what will the gender ratio of the new generation be?
 * Assume that the odds of someone having a boy or a girl on any given pregnancy is equal.
 * Solve this out logically and then write a computer simulation of it.
 * ***
 * - Cracking the coding interview, a book by Gayle Mcdowell (6th ed., q 6.7)
 */
public class TheApocalypse {

    // we will aways have p(0.5) to have a girl and p(0.5) to have a boy
    // so, surprisingly we will have a ratio of 1:1

    public static void main(String[] args) {
        System.out.println(calculateGirlsRationOfMultipleFamilies(1));
        System.out.println(calculateGirlsRationOfMultipleFamilies(2));
        System.out.println(calculateGirlsRationOfMultipleFamilies(5));
        System.out.println(calculateGirlsRationOfMultipleFamilies(10));
        System.out.println(calculateGirlsRationOfMultipleFamilies(20));
        System.out.println(calculateGirlsRationOfMultipleFamilies(50));
        System.out.println(calculateGirlsRationOfMultipleFamilies(100));
        System.out.println(calculateGirlsRationOfMultipleFamilies(1000));
        System.out.println(calculateGirlsRationOfMultipleFamilies(10000));
        System.out.println(calculateGirlsRationOfMultipleFamilies(1000000));
    }

    private static double calculateGirlsRationOfMultipleFamilies(int n) {
        int girls = 0;
        int boys = 0;

        for (int i = 0; i < n; i++) {
            int[] genders = countChildrenOfOneFamily();
            girls += genders[0];
            boys += genders[1];
        }

        return girls / (double) (girls + boys);
    }

    private static int[] countChildrenOfOneFamily() {
        int girls = 0;
        int boys = 0;
        Random random = new Random();

        while (girls == 0) {
            if (random.nextBoolean()) girls++;
            else boys++;
        }

        return new int[]{girls, boys};
    }
}
