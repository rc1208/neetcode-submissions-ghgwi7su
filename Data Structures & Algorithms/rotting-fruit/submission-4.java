class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> q = new ArrayDeque();
        int freshFruits=0;
        int time=-1;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.addLast(new int[]{i,j});
                }

                if (grid[i][j] == 1) {
                    freshFruits++;
                }
            }
        }


        
        int rottenFruits=0;

        Set<String> visited = new HashSet();

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i=0; i<size; i++) {
                int[] popped = q.removeFirst();
                int row = popped[0];
                int col = popped[1];

                // left
                if (col - 1 >=0
                 && !visited.contains(row + " " + (col-1))
                 && grid[row][col-1] == 1) {
                    q.addLast(new int[]{row, col-1});
                    grid[row][col-1] = 2;
                    rottenFruits++;
                }

                // right
                if (col + 1 < grid[0].length
                 && !visited.contains(row + " " + (col+1))
                 && grid[row][col+1] == 1) {
                    q.addLast(new int[]{row, col+1});
                    grid[row][col+1] = 2;
                    rottenFruits++;
                }

                // top
                if (row - 1 >=0
                 && !visited.contains((row-1) + " " + (col))
                 && grid[row-1][col] == 1) {
                    q.addLast(new int[]{row-1, col});
                    grid[row-1][col] = 2;
                    rottenFruits++;
                }

                // top
                if (row + 1 < grid.length
                 && !visited.contains((row+1) + " " + (col))
                 && grid[row+1][col] == 1) {
                    q.addLast(new int[]{row+1, col});
                    grid[row+1][col] = 2;
                    rottenFruits++;
                }

            }
        }


        if (freshFruits != rottenFruits) return -1;

        if (freshFruits ==0 && rottenFruits==0) return 0;

        return time;
    }
}
