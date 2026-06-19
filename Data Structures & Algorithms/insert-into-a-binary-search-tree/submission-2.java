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
    
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)  {
            return new TreeNode(val);
        }

        insertBST(root, val);

        return root;
    }

    public void insertBST(TreeNode node, int val) {
        if (node.val > val) {
            if (node.left == null) {
                TreeNode newNode = new TreeNode(val);
                node.left = newNode;
                return;
            } else {
                insertBST(node.left, val);
            }
        }

        if (node.val < val) {
            if (node.right == null) {
                TreeNode newNode = new TreeNode(val);
                node.right = newNode;
                return;
            } else {
                insertBST(node.right, val);
            }
        }
    }
}

/*
if node.val > val:
    if node.left == null insert
    else:
     then LST
if node.val < val:
    if node.right == null insert
    else:
     then RST
if node.
*/