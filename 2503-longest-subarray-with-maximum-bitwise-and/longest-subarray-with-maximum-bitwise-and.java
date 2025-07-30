class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;

        // Step 1: Find the maximum value in the array
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Step 2: Find the longest contiguous subarray of max
        int maxLen = 0;
        int currLen = 0;

        for (int num : nums) {
            if (num == max) {
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                currLen = 0;
            }
        }

        return maxLen;
    }
}
