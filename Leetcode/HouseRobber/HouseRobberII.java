package Leetcode.HouseRobber;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] robs) {
        int n = robs.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return robs[0];
        return Math.max(rob_helper(Arrays.copyOfRange(robs, 0, n - 1)),
                rob_helper(Arrays.copyOfRange(robs, 1, n)));

    }

    public int rob_helper(int[] robs) {
        int n = robs.length;
        int previous = 0;
        int twoHousesBefore = 0;
        for (int i = 0; i < n; i++) {
            int bestChance = Math.max(previous, robs[i] + twoHousesBefore);
            twoHousesBefore = previous;
            previous = bestChance;
        }
        return Math.max(previous, twoHousesBefore);
    }

    public static void main(String[] args) {
        int[] robs = { 2, 3, 7, 1, 11, 9, 1, 7, 6, 8 };
        HouseRobberII hRobberII = new HouseRobberII();
        int result = hRobberII.rob(robs);
        System.out.println(result);
        // for the 198. House Robber , use only the rob_helper directly
    }
}
