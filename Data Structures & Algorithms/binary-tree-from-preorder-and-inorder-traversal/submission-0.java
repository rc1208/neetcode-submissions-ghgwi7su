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
    int index=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // pre-order
        // root, left, right

        // in-order
        // left, root, right

        Map<Integer, Integer> map = new HashMap();

        for (int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        int index=0;
        int left=0;
        int right=preorder.length-1;
        return constructTree(preorder, inorder, map, left, right);
    }

    public TreeNode constructTree(int[] preorder, int[] inorder,
    Map<Integer, Integer> map, int left, int right) {
        if (left > right) return null;

        int value = preorder[index];
        TreeNode node = new TreeNode(value);
        System.out.println(node.val + " " + "left=" + left  + " right=" + right);
        
        index++; 
        node.left = constructTree(preorder, inorder,
         map, left, map.get(value) - 1);
        

        
        node.right = constructTree(preorder, inorder,
         map, map.get(value) + 1, right);
        
        return node;
    }
}
