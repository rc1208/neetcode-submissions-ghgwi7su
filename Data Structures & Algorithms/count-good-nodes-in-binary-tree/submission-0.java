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
    int count = 0;
    public int goodNodes(TreeNode root) {
        int maxValue = Integer.MIN_VALUE;
        findGoodnodes(root, maxValue);
        return count;
    }

    public void findGoodnodes(TreeNode node, int maxValue) {
        if (node == null) return;

        if (node.val >= maxValue) count++;

        findGoodnodes(node.left, Math.max(node.val, maxValue));
        findGoodnodes(node.right, Math.max(node.val, maxValue));

    }
}
