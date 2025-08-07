import java.util.Arrays;

class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int res = 0;

        // Step 1: Collect main diagonal fruits
        for (int i = 0; i < n; i++) {
            res += fruits[i][i];
        }

        // Step 2: Do two passes (original and transposed)
        for (int pass = 0; pass < 2; pass++) {
            // Transpose the matrix on second pass
            if (pass == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        int temp = fruits[i][j];
                        fruits[i][j] = fruits[j][i];
                        fruits[j][i] = temp;
                    }
                }
            }

            int[] prev = new int[n];
            int[] curr = new int[n];
            Arrays.fill(prev, -1);

            // Starting point
            prev[n - 1] = fruits[0][n - 1];

            // DP to find max collected fruits along the path
            for (int row = 1; row < n - 1; row++) {
                Arrays.fill(curr, -1);
                for (int i = 0; i < n; i++) {
                    if (prev[i] < 0) continue;

                    // Move down-left
                    if (i > 0)
                        curr[i - 1] = Math.max(curr[i - 1], prev[i] + fruits[row][i - 1]);

                    // Move down
                    curr[i] = Math.max(curr[i], prev[i] + fruits[row][i]);

                    // Move down-right
                    if (i < n - 1)
                        curr[i + 1] = Math.max(curr[i + 1], prev[i] + fruits[row][i + 1]);
                }

                // Swap arrays for next iteration
                int[] temp = prev;
                prev = curr;
                curr = temp;
            }

            // Add max fruits from the last row at column n-1
            res += prev[n - 1];
        }

        return res;
    }
}
