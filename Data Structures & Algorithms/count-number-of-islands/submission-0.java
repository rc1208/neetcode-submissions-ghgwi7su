class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        System.out.println(visited[0][0]);

        int count=0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length;j++) {
                if (grid[i][j] == '1' && visited[i][j] == false) {
                    doDfs(grid, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void doDfs(char[][] grid, int i, int j, boolean[][] visited) {
        if (i <0 || i==grid.length || j<0 || j==grid[0].length) return;
        if (visited[i][j] == true) return;
        if (grid[i][j] == '0') return;

        visited[i][j] = true;

        doDfs(grid, i-1, j, visited);
        doDfs(grid, i+1, j, visited);
        doDfs(grid, i, j+1, visited);
        doDfs(grid, i, j-1, visited);
    }
}
