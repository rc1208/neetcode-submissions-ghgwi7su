/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        // System.out.println(grid[0].length);
        return constructQuadTree(grid, 0, grid.length, 0, grid[0].length);
    }

    public Node constructQuadTree(int[][] grid, int bottom, int top, int left, int right) {
        System.out.println(left + " " + right + " " + bottom +  " " + top);
        if (checkVal(grid, left, right, top, bottom)) {
        
            if (grid[bottom][left] == 1) return new Node(true, true);
            else return new Node(false, true);
        }

        // if (left == grid.length || right == 0 || top == grid[0].length || bottom == 0) return;

        Node node = new Node(true, false);

        node.topLeft = constructQuadTree(grid, bottom, (bottom + top)/2, left, (left + right)/2);
        node.topRight = constructQuadTree(grid, bottom, (bottom + top)/2, (left + right)/2, right);
        node.bottomLeft = constructQuadTree(grid, (bottom + top)/2, top, left, (left + right)/2);
        node.bottomRight = constructQuadTree(grid, (bottom + top)/2, top, (left + right)/2, right);

        return node;

    }

    public boolean checkVal(int[][] grid, int left, int right, int top, int bottom) {
        for (int i=bottom; i<top; i++) {
            for (int j=left; j<right; j++) {
                if (grid[bottom][left] != grid[i][j]) return false;
            }
        }

        return true;
    }
}