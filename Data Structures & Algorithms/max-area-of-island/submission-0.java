class Solution {
    int maxArea = 0;
    int area =0;
    public int maxAreaOfIsland(int[][] grid) {
        
        
        Set<String> visited = new HashSet<String>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                String s = i + "." + j;
                
                if (!visited.contains(s) && grid[i][j] == 1) {
                    // System.out.println(i + "/" + j);
                    doDfs(grid, i, j, visited);
                    maxArea = Math.max(maxArea, area);
                    area=0;
                }
            }
        }

        return maxArea;
    }

    public void doDfs(int[][] grid, int r, int c, Set<String> visited) {

        if (r<0 || r == grid.length || c<0 || c == grid[0].length) return;

        if (grid[r][c] == 0) return;

        String setVal = r + "." + c;

        if (visited.contains(setVal)) return;
        

        
        // System.out.println(setVal);

        visited.add(setVal);
        area++;

        doDfs(grid, r + 1, c, visited);
        doDfs(grid, r - 1, c, visited);
        doDfs(grid, r, c + 1, visited);
        doDfs(grid, r, c - 1, visited);


    }
}
