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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode node, int targetSum, int sumSoFar) {
        if (node == null) return false;

        sumSoFar += node.val;

        if (sumSoFar == targetSum && node.left == null && node.right == null) return true;

   
            return dfs(node.left, targetSum, sumSoFar) || dfs(node.right, targetSum, sumSoFar);
    

    }
}