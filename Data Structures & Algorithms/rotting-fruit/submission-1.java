class Solution {
    public int orangesRotting(int[][] grid) {
     int freshFruits = 0;

     for (int i=0; i<grid.length; i++) {
        for (int j=0; j<grid[0].length; j++) {
            if (grid[i][j] == 1) freshFruits++;
        }
     }
     int time=0;
     time = bfs(grid, time);

     int newFreshFruits = countFreshFruits(grid);

     if (newFreshFruits != 0) time=-1;

     return time;
    }

    public int bfs(int[][] grid, int time) {
        Deque<int[]> q = new ArrayDeque();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    int[] elem = {i,j};
                    q.addLast(elem);
                }
            }
        }

        Set<String> visited = new HashSet();
        while (!q.isEmpty() && countFreshFruits(grid) !=0) {
            int size = q.size();

            time++;

            for (int i=0; i<size; i++) {
                int[] poppedNode = q.removeFirst();
                int row = poppedNode[0];
                int col = poppedNode[1];

                System.out.println(time + " poppedNode= " + row +  " " + col);

                //left
                if (col-1 >=0 && !visited.contains(row + " " + (col-1)) && grid[row][col-1] == 1) {
                    grid[row][col-1] = 2;
                    visited.add(row + " " + (col-1));
                    q.addLast(new int[]{row, col-1});
                }

                //right
                if (col+1 < grid[0].length && !visited.contains(row + " " + (col+1)) && grid[row][col+1] == 1) {
                    grid[row][col+1] = 2;
                    visited.add(row + " " + (col+1));
                    q.addLast(new int[]{row, col+1});

                }

                //top
                if (row-1 >=0 && !visited.contains((row-1) + " " + col) && grid[row-1][col] == 1) {
                    grid[row-1][col] = 2;
                    visited.add((row-1) + " " + col);
                    q.addLast(new int[]{row-1, col});
                }

                //bottom
                if (row+1 < grid.length && !visited.contains((row+1) + " " + col) && grid[row+1][col] == 1) {
                    grid[row+1][col] = 2;
                    visited.add((row+1) + " " + col);
                    q.addLast(new int[]{row+1, col});
                }
            }
        }

        return time;
    }

    public int countFreshFruits(int[][] grid) {
        int newFreshFruits=0;   

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) newFreshFruits++;
            }
        }

        return newFreshFruits;
    }
}
