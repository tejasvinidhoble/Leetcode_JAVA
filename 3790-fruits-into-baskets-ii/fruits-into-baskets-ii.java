class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n]; // Tracks if a basket is used
        int unplaced = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;

            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;  // Mark this basket as used
                    placed = true;
                    break;
                }
            }

            if (!placed) {
                unplaced++;  // Fruit couldn't be placed in any basket
            }
        }

        return unplaced;
    }
}
