// https://www.geeksforgeeks.org/dsa/activity-selection-problem-greedy-algo-1/

import java.util.*;

public class ActivitySelectionProblem {

    // Function to solve the activity selection problem
    public static int activitySelection(int[] start, int[] finish) {
        int n = start.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = start[i];
            arr[i][1] = finish[i];
        }

        // Sort activities by finish time
        Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

        // At least one activity can be performed
        int count = 1;

        // Index of last selected activity
        int j = 0;

        for (int i = 1; i < n; i++) {

            // Check if current activity starts
            // after last selected activity finishes
            if (arr[i][0] > arr[j][1]) {
                count++;

                // Update last selected activity
                j = i;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of activities:");
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] finish = new int[n];

        System.out.println("Enter start times:");
        for (int i = 0; i < n; i++) {
            start[i] = sc.nextInt();
        }

        System.out.println("Enter finish times:");
        for (int i = 0; i < n; i++) {
            finish[i] = sc.nextInt();
        }

        int result = activitySelection(start, finish);
        System.out.println("Maximum number of activities that can be performed: " + result);
        sc.close();
    }
}
