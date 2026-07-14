class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m= matrix.length;
        int n=matrix[0].length;
        int[][] dp = new int[m+1][n+1];

        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                int bottom = dp[i+1][j];;
                

                int right = dp[i][j+1];
                
                int diag = dp [i+1][j+1];

            

                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    int min1 = Math.min(bottom, right);
                    int min2 = Math.min(min1, diag);
                    dp[i][j] = 1 + min2;
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        if (max == Integer.MIN_VALUE) return 0;

        return max*max;
    }
}