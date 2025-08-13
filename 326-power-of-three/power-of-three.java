class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false; // negative numbers or zero can't be power of three
        
        while (n % 3 == 0) { // keep dividing by 3 while divisible
            n /= 3;
        }
        
        return n == 1; // if we end at 1, it's a power of three
    }
}
