// // https://codeforces.com/problemset/problem/1343/B

import java.util.*;

class BalancedArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            if (n % 4 != 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");

                List<Integer> result = new ArrayList<>();
                int evenSum = 0;
                int oddSum = 0;

                for (int i = 1; i <= n / 2; i++) {
                    int even = i * 2;
                    result.add(even);
                    evenSum += even;
                }
                for (int i = 1; i < n / 2; i++) {
                    int odd = i * 2 - 1;
                    result.add(odd);
                    oddSum += odd;
                }
                int lastSum = evenSum - oddSum;
                result.add(lastSum);
                for (int num : result) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
