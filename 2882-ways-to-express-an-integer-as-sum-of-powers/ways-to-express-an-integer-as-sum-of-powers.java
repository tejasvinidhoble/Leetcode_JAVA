class Solution {
    private static final int MOD = 1000000007;
    private int[][] dp;

    public int numberOfWays(int n, int x) {
        dp = new int[301][n + 1]; // n ≤ 300
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(1, n, x);
    }

    private int helper(int curr, int target, int x) {
        if (target == 0) return 1; // found a valid combination
        if (curr > 300) return 0; // no numbers left
        int pow = (int) Math.pow(curr, x);
        if (pow > target) return 0; // can't use curr

        if (dp[curr][target] != -1) return dp[curr][target];

        // Option 1: Take current number
        int take = helper(curr + 1, target - pow, x) % MOD;

        // Option 2: Skip current number
        int skip = helper(curr + 1, target, x) % MOD;

        return dp[curr][target] = (take + skip) % MOD;
    }
}
