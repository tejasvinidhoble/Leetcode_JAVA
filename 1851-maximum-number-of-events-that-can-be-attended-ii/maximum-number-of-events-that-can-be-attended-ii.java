class Solution {
    public int maxValue(int[][] events, int k) {
          Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] dp = new int[events.length][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(0, k, events, dp);
    }

    private int helper(int i, int k, int[][] events, int[][] dp) {
        if (i == events.length || k == 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];

        
        int notTake = helper(i + 1, k, events, dp);

        
        int next = findNext(events, i);
        int take = events[i][2] + helper(next, k - 1, events, dp);

        return dp[i][k] = Math.max(take, notTake);
    }

   
    private int findNext(int[][] events, int i) {
        int low = i + 1, high = events.length;
        int target = events[i][1]; 

        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] > target)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }
}