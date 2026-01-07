/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    int MOD = 1000000007;

    public int maxProduct(TreeNode root) {
        // Step 1: find total sum of the tree
        totalSum = totalTreeSum(root);

        // Step 2: find max product by splitting
        subtreeSum(root);

        // Step 3: return answer modulo
        return (int)(maxProduct % MOD);
    }

    // DFS to calculate total sum
    private long totalTreeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + totalTreeSum(node.left) + totalTreeSum(node.right);
    }

    // DFS to calculate subtree sums and max product
    private long subtreeSum(TreeNode node) {
        if (node == null) return 0;

        long left = subtreeSum(node.left);
        long right = subtreeSum(node.right);

        long currentSum = node.val + left + right;

        long product = currentSum * (totalSum - currentSum);
        maxProduct = Math.max(maxProduct, product);

        return currentSum;
    }
}