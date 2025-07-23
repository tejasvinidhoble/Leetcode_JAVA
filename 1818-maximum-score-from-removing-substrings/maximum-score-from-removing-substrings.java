class Solution {
    public int maximumGain(String s, int x, int y) {
        int total = 0;

        if (x >= y) {
            Result afterFirst = removePattern(s, 'a', 'b', x);
            total += afterFirst.score;
            Result afterSecond = removePattern(afterFirst.updated, 'b', 'a', y);
            total += afterSecond.score;
        } else {
            Result afterFirst = removePattern(s, 'b', 'a', y);
            total += afterFirst.score;
            Result afterSecond = removePattern(afterFirst.updated, 'a', 'b', x);
            total += afterSecond.score;
        }

        return total;
    }

    private static class Result {
        String updated;
        int score;
        Result(String updated, int score) {
            this.updated = updated;
            this.score = score;
        }
    }

    private Result removePattern(String s, char first, char second, int value) {
        StringBuilder stack = new StringBuilder();
        int score = 0;

        for (char ch : s.toCharArray()) {
            int len = stack.length();
            if (len > 0 && stack.charAt(len - 1) == first && ch == second) {
                stack.deleteCharAt(len - 1);
                score += value;
            } else {
                stack.append(ch);
            }
        }

        return new Result(stack.toString(), score);
    }
}