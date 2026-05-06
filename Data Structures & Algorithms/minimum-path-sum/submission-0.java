class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];

        dp[0][0] = grid[0][0];

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (i==0 && j==0) continue;
                int currVal = dp[i][j];

                int minLeft;
                if (j-1 >= 0) {
                    minLeft = dp[i][j-1];
                } else {
                    minLeft = Integer.MAX_VALUE;
                }

                int minTop;
                if (i-1 >= 0) {
                    minTop = dp[i-1][j];
                } else {
                    minTop = Integer.MAX_VALUE;
                }

                dp[i][j] = grid[i][j] + Math.min(minLeft, minTop);


            }
        }


        return dp[dp.length-1][grid[0].length-1];
    }
}