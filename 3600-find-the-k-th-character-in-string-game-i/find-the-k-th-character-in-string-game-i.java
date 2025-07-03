class Solution {
    public char kthCharacter(int k) {
         int index = k - 1;
         int increments = 0;

    while (index > 0) {
        long p = 1;

        while (p * 2 <= index) {
            p *= 2;
        }
        increments++;
        index -= p;
    }

    return (char) ('a' + (increments % 26));
    }
}