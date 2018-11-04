import java.util.Stack;

/**
 * *** Interview question ***
 * <p>
 * Problem: Largest Rectangle in a Histogram
 * <p>
 * Problem statement and more details: https://youtu.be/RVIh0snn4Qc
 */
public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        System.out.println(findLargestRectangleArea(new int[]{1, 2, 3, 4, 5, 3, 3, 2}));
        System.out.println(findLargestRectangleArea(new int[]{0, 0, 0, 0}));
        System.out.println(findLargestRectangleArea(new int[]{4, 3, 2, 1}));
        System.out.println(findLargestRectangleArea(new int[]{4, 3, 2, 1, 1, 2, 3, 4}));
    }

    private static int findLargestRectangleArea(int[] hist) {
        Stack<Integer> stack = new Stack<>();
        int max = 0, i = 0;

        while (i < hist.length) {
            if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
                stack.push(i++);
            } else {
                int area = getCurrentMax(hist, stack, i);
                if (area > max) max = area;
            }
        }

        while (!stack.isEmpty()) {
            int area = getCurrentMax(hist, stack, i);
            if (area > max) max = area;
        }

        return max;
    }

    private static int getCurrentMax(int[] hist, Stack<Integer> stack, int index) {
        int currIndex = stack.pop();
        return hist[currIndex] * (stack.isEmpty() ? index : index - 1 - stack.peek());
    }
}