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
    int ans = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        findDiam(root);

        return ans;
    }

    public int findDiam(TreeNode node) {

        if (node == null) return 0;

        int maxLeft = findDiam(node.left);
        int maxRight = findDiam(node.right);

        
        ans = Math.max(ans, maxLeft + maxRight);

        return 1 + Math.max(maxLeft, maxRight);
    } 
}
