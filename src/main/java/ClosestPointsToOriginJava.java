import java.util.*;
import java.util.stream.Collectors;


/**
 * Find K closest points to the origin (0,0).
 * Problem statement and more details: https://youtu.be/eaYX0Ee0Kcg
 */
public class ClosestPointsToOriginJava {

    public static void main(String[] args) {
        ArrayList<Double[]> points = new ArrayList<>();
        points.add(new Double[]{-2.0, 4.0});
        points.add(new Double[]{0.0, -2.0});
        points.add(new Double[]{-1.0, 0.0});
        points.add(new Double[]{3.0, 5.0});
        points.add(new Double[]{-2.0, -3.0});
        points.add(new Double[]{3.0, 2.0});

        System.out.println(firstSolution(points, 0));
        System.out.println(firstSolution(points, 2));
        System.out.println(firstSolution(points, 4));
        System.out.println(firstSolution(points, 6));
        System.out.println(firstSolution(points, 8));

        System.out.println("*****************************************************************************");

        System.out.println(secondSolution(points, 0));
        System.out.println(secondSolution(points, 2));
        System.out.println(secondSolution(points, 4));
        System.out.println(secondSolution(points, 6));
//        System.out.println(secondSolution(points, 8));
    }

    private static List<List<Double>> firstSolution(List<Double[]> points, int k) {
        return points.stream()
                .map(p -> List.of(p[0], p[1], Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2))))
                .sorted(Comparator.comparing(x -> x.get(2)))
                .limit(k)
                .map(p -> List.of(p.get(0), p.get(1)))
                .collect(Collectors.toList());
    }

    // faster
    private static List<List<Double>> secondSolution(List<Double[]> points, int k) {
        ArrayList<ArrayList<Double>> pts = new ArrayList<>();
        points.forEach(p -> pts.add(new ArrayList<>(Arrays.asList(p))));

        pts.forEach(p -> p.add(Math.sqrt(Math.pow(p.get(0), 2) + Math.pow(p.get(1), 2))));
        PriorityQueue<List<Double>> heap = new PriorityQueue<>(Comparator.comparing(x -> x.get(2)));
        pts.forEach(heap::offer);

        List<List<Double>> results = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            results.add(heap.poll());
        }

        return results.stream().map(p -> List.of(p.get(0), p.get(1))).collect(Collectors.toList());
    }
}
