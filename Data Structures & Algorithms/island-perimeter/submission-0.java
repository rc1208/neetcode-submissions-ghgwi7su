class Solution {
    int perim=0;
    public int islandPerimeter(int[][] grid) {
        

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    doDfs(grid, i, j, new HashSet());
                    return perim;
                }
            }
        }

        return perim;
    }

    public void doDfs(int[][] grid, int row, int  col, Set<String> visited) {

        if (row <0 || row==grid.length || col <0 || col == grid[0].length) return;

        if (visited.contains(row + "." + col)) return;

        visited.add(row + "." + col);

        if (grid[row][col] == 0) return;

        if (row - 1 < 0) perim++;
        if (row + 1 == grid.length) perim++;

        if (col - 1 < 0 ) perim++;
        if (col + 1 == grid[0].length) perim++;

        if ((row  - 1 >=0 && grid[row -1][col] == 0)) perim++;
        if (row + 1 < grid.length && grid[row+1][col] == 0) perim++;

        if (col - 1 >=0 && grid[row][col-1] == 0) perim++;
        if (col + 1 < grid[0].length && grid[row][col+1] == 0) perim++;

        // System.out.println(row + " " + col +  " " + perim);

        doDfs(grid, row-1, col, visited);
        doDfs(grid, row+1, col, visited);
        doDfs(grid, row, col-1, visited);
        doDfs(grid, row, col+1, visited);

    }
}