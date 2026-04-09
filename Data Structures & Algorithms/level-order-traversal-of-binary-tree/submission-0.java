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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList();
        List<List<Integer>>  ans = new LinkedList();
        if (root == null) return ans;
        System.out.println(root);

        q.addLast(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> subList = new ArrayList();
            for (int i=1; i<=size; i++) {
                TreeNode removedNode = q.removeFirst();
                subList.add(removedNode.val);
                if (removedNode.left != null) q.addLast(removedNode.left);
                if (removedNode.right != null) q.addLast(removedNode.right);
            }

            ans.add(subList);
            
        }


        return ans;
    }
}
