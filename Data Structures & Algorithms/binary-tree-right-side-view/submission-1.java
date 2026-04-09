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
    public List<Integer> rightSideView(TreeNode root) {

        Deque<TreeNode> q = new LinkedList();
        List<Integer> ans = new ArrayList();

        if (root == null) return ans;

        q.addFirst(root);


        while(!q.isEmpty()) {
            int size = q.size();

            for (int i=1; i<=size; i++) {
                TreeNode removedNode = q.removeFirst();
                if (i==size) ans.add(removedNode.val);

                if (removedNode.left != null) q.addLast(removedNode.left);
                if (removedNode.right != null) q.addLast(removedNode.right);
            }
        }

        return ans;
    }
}
