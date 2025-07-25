class Solution 
{
    public int maxSum(int[] nums) 
    {
     
        int totalSum = 0;

       
        int maxElement = Integer.MIN_VALUE;

        
        HashSet<Integer> used = new HashSet<>();

        
        for (int num : nums) 
        {
            maxElement = Math.max(maxElement, num);
            if (num > 0 && used.add(num)) 
            {
                totalSum += num;
            }
        }

        
        return totalSum > 0 ? totalSum : maxElement;
    }
}