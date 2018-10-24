/**
 * *** 'Google' interview question ***
 *
 * Determine whether a circular array of relative indices is composed of a single complete cycle.
 * <p>
 * Examples:
 * [2,2,-1]        => true
 * ---> array[0] will go 2 steps ahead to array[2]
 * ---> array[2] will back 1 step to array[1]
 * ---> array[1] will go 2 steps ahead to array[0]
 * <p>
 * [1,-1,3]        => false
 * ---> array[0] will go 1 step ahead to array[1]
 * ---> array[1] will back 1 step to array[0]
 * ---> we will never reach array[2]
 * <p>
 * [3,1,2,-2,1]    => true
 * [2,5,-3,-2,-2]  => false
 */
public class SingleCompleteCycle {

    public static void main(String[] args) {
        SingleCompleteCycle tester = new SingleCompleteCycle();

        System.out.println(tester.isSingleCompleteCycle(new int[]{2, 2, -1}));
        System.out.println(tester.isSingleCompleteCycle(new int[]{1, -1, 3}));
        System.out.println(tester.isSingleCompleteCycle(new int[]{3, 1, 2, -2, 1}));
        System.out.println(tester.isSingleCompleteCycle(new int[]{2, 5, -3, -2, -2}));
    }

    private boolean isSingleCompleteCycle(int[] array) {
        int currPos = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            currPos = (currPos + array[currPos]) % length;
            if (currPos < 0) currPos += length;
            if (currPos == 0 && i != length - 1) return false;
        }
        return currPos == 0;
    }

}
