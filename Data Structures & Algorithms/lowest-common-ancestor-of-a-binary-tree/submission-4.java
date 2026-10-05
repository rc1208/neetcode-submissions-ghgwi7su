/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p==null || q== null || root == null) return null;
        Map<TreeNode, TreeNode> parentMap = new HashMap();

        parentMap.put(root, new TreeNode(Integer.MIN_VALUE));

        Deque<TreeNode> queue = new ArrayDeque();

        queue.addLast(root);
        // System.out.println(root.val);


        while (!queue.isEmpty()) {
            TreeNode poppedNode = queue.removeFirst();
            // System.out.println(poppedNode.val);
            if (poppedNode.left != null) {
                queue.addLast(poppedNode.left);
                parentMap.put(poppedNode.left, poppedNode);
            }

            if (poppedNode.right != null) {
                queue.addLast(poppedNode.right);
                parentMap.put(poppedNode.right, poppedNode);
            }
        }

        Set<TreeNode> setP = new HashSet();
        TreeNode curr = p;
        while (curr.val != Integer.MIN_VALUE) {
            setP.add(curr);
            // System.out.println(p.val);
            if (parentMap.containsKey(curr)) {
                curr = parentMap.get(curr);
            } else {
                break;
            } 
        }


        curr = q;
        while (!setP.contains(curr)) {
            curr = parentMap.get(curr);
        }


        return curr;


    }
}

// 5 -> 3
// 5 -> 3 -> 1 -> 12