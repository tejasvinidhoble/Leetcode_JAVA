class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums); // Step 1: Sort the array
        int n = nums.length;

        // Step 2: Check if valid triplets can be formed
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < n; i += 3) {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];

            // Step 3: Check the max difference in triplet
            if (c - a > k) {
                return new int[0][];
            }

            result.add(new int[]{a, b, c});
        }

        // Step 4: Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}
