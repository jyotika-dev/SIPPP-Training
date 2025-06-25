// https://leetcode.com/problems/k-closest-points-to-origin/

import java.util.Arrays;
import java.util.Comparator;

class kClosestPointsOrigin {

    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, Comparator.comparing(p -> p[0] * p[0] + p[1] * p[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}
