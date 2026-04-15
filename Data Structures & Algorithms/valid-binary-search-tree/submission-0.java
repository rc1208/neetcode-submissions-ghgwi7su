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
    public boolean isValidBST(TreeNode root) {
        int minVal=Integer.MIN_VALUE;
        int maxVal=Integer.MAX_VALUE;

        return findisValidBST(root, minVal, maxVal);
    }

    public boolean findisValidBST(TreeNode node, int minVal, int maxVal) {

        if (node  == null) return true;

        boolean isLSTValid = findisValidBST(node.left, minVal, node.val);
        boolean isRSTValid = findisValidBST(node.right, node.val, maxVal);

        return node.val > minVal && 
               node.val < maxVal && 
               isLSTValid &&
               isRSTValid;
    }
}
