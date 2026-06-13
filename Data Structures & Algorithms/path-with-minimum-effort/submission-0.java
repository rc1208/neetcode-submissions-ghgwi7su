class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int[][] distance = new int[heights.length][heights[0].length];
        for (int i=0; i< distance.length; i++) {
            for (int j=0; j<distance[0].length; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        pq.add(new int[]{0,0,0});

        int[][] directions = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!pq.isEmpty()) {
            int[] poppedNode = pq.poll();
           
            int currDist = poppedNode[0];
            int row = poppedNode[1];
            int col = poppedNode[2];

            //already visited
            if (distance[row][col] <  currDist) continue;

            if (row == heights.length-1 && col == heights[0].length-1) {
                return currDist;
            } 

            for (int[] dir: directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow == heights.length || newCol < 0 || newCol == heights[0].length) continue;

                int newDiff = Math.max(currDist, Math.abs(heights[row][col] - heights[newRow][newCol]));

                if (newDiff < distance[newRow][newCol]) {
                    distance[newRow][newCol] = newDiff;
                    pq.add(new int[]{newDiff, newRow, newCol});
                }
            }
        }


        return distance[heights.length-1][heights.length-1];


    }
}