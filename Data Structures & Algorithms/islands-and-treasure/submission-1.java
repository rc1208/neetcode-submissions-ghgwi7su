class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque();

        for (int i=0; i< grid.length; i++) {
            for (int j=0; j< grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int[] cell = {i, j};
                    queue.addLast(cell);
                }
                
             }
        }
        Set<String> visited = new HashSet();
        System.out.println(queue.size());
        int distance = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            distance++;
            for (int i=1; i <=size; i++) {
                
                int[] poppedNode = queue.removeFirst();
                System.out.println(poppedNode);
                int row = poppedNode[0];
                int col = poppedNode[1];

                if (grid[row][col] == -1) continue;
                if (visited.contains(row + " " + col)) continue;
                visited.add(row + " " + col);
                
                if (grid[row][col] != 0) {
                    grid[row][col] = Math.min(grid[row][col], distance-1);
                }
                

                if (row-1 >=0) {
                    int[] neigh = {row-1, col};
                    queue.addLast(neigh);
                }

                if (row+1 < grid.length) {
                    int[] neigh = {row+1, col};
                    queue.addLast(neigh);
                }

                if (col-1 >=0) {
                    int[] neigh = {row, col-1};
                    queue.addLast(neigh);
                }

                if (col+1 < grid[0].length) {
                    int[] neigh = {row, col+1};
                    queue.addLast(neigh);
                }
            }  
        }
    }
}
