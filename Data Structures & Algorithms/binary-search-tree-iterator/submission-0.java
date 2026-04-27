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
class BSTIterator {
    TreeNode ptr;
    List<TreeNode> inOrder;
    int ptrIndex;
    public BSTIterator(TreeNode root) {
        ptr = new TreeNode(-1);
        ptrIndex=0;
        inOrder = new LinkedList();
        inOrder.add(ptr);
        inOrderTraversal(root, inOrder);

    }
    
    public int next() {
        ptrIndex++;
        return inOrder.get(ptrIndex).val;
    }
    
    public boolean hasNext() {
        if (ptrIndex == inOrder.size()-1) return false;
        else return true;
    }

    public void inOrderTraversal(TreeNode node, List<TreeNode> inOrder) {
        if (node == null) return;

        inOrderTraversal(node.left, inOrder);
        inOrder.add(node);
        inOrderTraversal(node.right, inOrder);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */