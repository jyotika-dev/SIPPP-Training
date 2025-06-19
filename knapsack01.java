
import java.util.Scanner;

public class knapsack01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of items
        int maxWeight = sc.nextInt(); // maximum weight capacity of the knapsack
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt(); // weight of each item
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt(); // value of each item
        }
        sc.close();
        System.out.println(knapsack(weight, value, n, maxWeight));
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        return solve(weight, value, n, maxWeight);
    }

    static int solve(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n + 1][maxWeight + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int w = 0; w <= maxWeight; w++) {
                int answer;
                if (weight[i] <= w) {
                    int ans1 = value[i] + dp[i + 1][w - weight[i]];
                    int ans2 = dp[i + 1][w];
                    answer = Math.max(ans1, ans2);
                } else {
                    answer = dp[i + 1][w];
                }
                dp[i][w] = answer;
            }
        }
        return dp[0][maxWeight];
    }
}
