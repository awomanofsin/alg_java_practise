public class Leetcode746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] cs = new int[len + 1];
        cs[0] = 0;
        cs[1] = 0;
        cs[2] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < len + 1; i++) {
            cs[i] = Math.min(cs[i - 1] + cost[i - 1], cs[i - 2] + cost[i - 2]);
        }
        return cs[len];
    }
}
