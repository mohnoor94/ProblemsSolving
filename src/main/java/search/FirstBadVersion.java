package search;

/**
 * First Bad Version
 * ***
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of
 * your product fails the quality check. Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following
 * ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to
 * find the first bad version. You should minimize the number of calls to the API.
 * ***
 * Example:
 * Given n = 5, and version = 4 is the first bad version.
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * ***
 * https://leetcode.com/articles/first-bad-version/
 */
public class FirstBadVersion {
  public static void main(String[] args) {
    testSolution(5);
    testSolution(100);
    testSolution(1000);
    testSolution(10000);
  }

  private static void testSolution(int n) {
    System.out.println("First Bad Version: " + findFirstBadVersion(n));
    System.out.println("*".repeat(44));
  }

  private static int findFirstBadVersion(int n) {
    if (n <= 0) return 0;
    if (n == 1) return isBadVersion(1) ? 1 : 0;

    int min = 1;
    int max = n;
    int mid;

    int steps = 0;  // FOR DEBUGGING ONLY

    while (min < max) {
      ++steps;  // FOR DEBUGGING ONLY
      mid = min + (max - min) / 2;
      if (isBadVersion(mid)) max = mid;
      else min = mid + 1;
    }

    System.out.printf("N: %s ,\tSteps: %s,\tFirst Bad Version: %s\n", n, steps, min); // FOR DEBUGGING ONLY
    return min;
  }

  private static boolean isBadVersion(int version) {
    return version > 3;
  }
}
