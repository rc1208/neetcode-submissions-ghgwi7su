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
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedTree(root);
        return ans;
    }

    public int isBalancedTree(TreeNode node) {
       if (node == null) return 0;

       int leftH = isBalancedTree(node.left);
       int rightH = isBalancedTree(node.right);

       if (Math.abs(leftH - rightH) > 1) ans = false;

       return 1 + Math.max(leftH, rightH);

    }

}
