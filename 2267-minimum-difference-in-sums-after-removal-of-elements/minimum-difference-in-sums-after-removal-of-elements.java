class Solution {
    public long minimumDifference(int[] nums) {
          int n3 = nums.length;
        int n = n3 / 3;

        long[] part1 = new long[n + 1];
        long sum = 0;

        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        
        for (int i = 0; i < n; ++i) {
            sum += nums[i];
            maxHeap.add(nums[i]);
        }
        part1[0] = sum;

       
        for (int i = n; i < 2 * n; ++i) {
            sum += nums[i];
            maxHeap.add(nums[i]);
            sum -= maxHeap.poll(); 
            part1[i - n + 1] = sum;
        }

        long part2 = 0;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        
        for (int i = n3 - 1; i >= 2 * n; --i) {
            part2 += nums[i];
            minHeap.add(nums[i]);
        }

       
        long ans = part1[n] - part2;

       
        for (int i = 2 * n - 1; i >= n; --i) {
            part2 += nums[i];
            minHeap.add(nums[i]);
            part2 -= minHeap.poll(); 
            ans = Math.min(ans, part1[i - n] - part2);
        }

        return ans;
    }
}