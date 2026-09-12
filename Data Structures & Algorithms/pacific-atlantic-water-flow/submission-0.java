class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;

        List<List<Integer>> ans = new ArrayList();

        int[][] atlantic = new int[ROWS][COLS];
        int[][] pacific = new int[ROWS][COLS];

        for (int c=0; c<COLS; c++) {
            //top row
            dfs(heights, 0, c, pacific);

            //bottom row
            dfs(heights, ROWS-1, c, atlantic);
        }


        for (int r=0; r<ROWS; r++) {
            //left col
            dfs(heights, r, 0, pacific);

            //right col
            dfs(heights, r, COLS-1, atlantic);
        }


        for (int r=0; r<ROWS; r++) {
            for (int c=0; c<COLS; c++) {

                if(atlantic[r][c] == 1 && pacific[r][c] == 1) {
                    List<Integer> cell = Arrays.asList(r, c);
                    ans.add(cell);

                }
            }
         }

        return ans;
        
    }


    public void dfs(int[][] heights, int r, int c, int[][] ocean) {
        ocean[r][c] = 1;
        
        int left = c - 1;

        if (left >= 0 && ocean[r][left] != 1 && heights[r][c] <= heights[r][left]) {
            dfs(heights, r, left, ocean);
        } 

        int right = c + 1;

        if (right < heights[0].length && ocean[r][right] != 1 && heights[r][c] <= heights[r][right]) {
            dfs(heights, r, right, ocean);
        } 

        int top = r - 1;

        if (top >= 0 && ocean[top][c] != 1 && heights[r][c] <= heights[top][c])  {
            dfs(heights, top, c, ocean);
        } 

        int bottom = r + 1;

        if (bottom < heights.length && ocean[bottom][c] != 1 && heights[r][c] <= heights[bottom][c]) {
            dfs(heights, bottom, c, ocean);
        } 
    }
}
