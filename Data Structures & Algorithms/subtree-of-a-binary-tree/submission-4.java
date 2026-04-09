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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return findisSubTree(root, subRoot);
    }

    public boolean findisSubTree(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null) return true;
         
        if (root == null && subroot != null) return false;
        if (root != null && subroot == null) return true;
        
        if (sameTree(root, subroot)) return true;

        return findisSubTree(root.left, subroot) || findisSubTree(root.right, subroot);
    }

    public boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        // System.out.println(t1.val + " " + t2.val + " " + sameTree(t1.left, t2.left) + " " + sameTree(t1.right, t2.right));

        return (t1.val == t2.val) && sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }
}
