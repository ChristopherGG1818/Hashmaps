//Extra credit
import java.util.*;
public class SubarraySumTarget {

    public static int[] sumTarget(int[] A, int K) {
        int n = A.length;
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < n; end++) {
            currentSum += A[end];

            while (currentSum > K && start < end) {
                currentSum -= A[start];
                start++;
            }
            if (currentSum == K) {
                return new int[]{start, end};
            }
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        // Example 1
        int[] A1 = {1, 2, 3, 7, 5};
        int K1 = 12;
        int[] result1 = sumTarget(A1, K1);
        System.out.println("Example 1: " + Arrays.toString(result1));

        int[] A2 = {1, 2, 3, 7, 5};
        int K2 = 5;
        int[] result2 = sumTarget(A2, K2);
        System.out.println("Example 2: " + Arrays.toString(result2));

        int[] A3 = {1, 2, 3, 7, 5};
        int K3 = 7;
        int[] result3 = sumTarget(A3, K3);
        System.out.println("Example 3: " + Arrays.toString(result3));

        int[] A4 = {1, 2, 3, 7, 5};
        int K4 = 11;
        int[] result4 = sumTarget(A4, K4);
        System.out.println("Example 4: " + Arrays.toString(result4));
    }
}