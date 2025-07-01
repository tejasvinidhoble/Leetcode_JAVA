class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        if (n == 0) return 0;

        int total = 0;
        int i = 0;

        while (i < n) {
            char currentChar = word.charAt(i);
            int count = 0;

            // Count consecutive same characters
            while (i < n && word.charAt(i) == currentChar) {
                count++;
                i++;
            }

            // If group size > 1, Alice might have pressed it too long
            if (count > 1) {
                total += (count - 1); // Possible shorter versions
            }
        }

        // Add 1 possibility: all characters typed correctly without mistake
        return total + 1;
    }
}
