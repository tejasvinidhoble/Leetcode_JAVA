class Solution {
    public String largestGoodInteger(String num) {
       String ans = "";
        for (int i = 0; i <= num.length() - 3; i++) {
            char c = num.charAt(i);
            // check if the next two characters are the same as c
            if (num.charAt(i + 1) == c && num.charAt(i + 2) == c) {
                String candidate = num.substring(i, i + 3);
                if (ans.equals("") || candidate.compareTo(ans) > 0) {
                    ans = candidate;
                }
            }
        }
        return ans; 
    }
}