class Solution {
    public int partitionArray(int[] nums, int k) {
          Arrays.sort(nums);  // Step 1: Sort the array

        int count = 1;      // Step 2: At least one subsequence is needed
        int start = nums[0]; // Step 3: Start element of the first group

        // Step 4: Loop through the array
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - start > k) {
                count++;           // Need a new subsequence
                start = nums[i];   // Update the start of new subsequence
            }
        }

        return count; // Step 5: Return total subsequences needed
    }
}