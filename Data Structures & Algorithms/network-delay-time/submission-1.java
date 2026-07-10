class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] fdist = new int[n+1];
        fdist[0] = Integer.MIN_VALUE;

        for (int i=1; i<= n; i++) {
            if (i==k) {
                fdist[i] = 0;
            } else {
                fdist[i] = Integer.MAX_VALUE; 
            }
            
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int[] arr = {k, 0};
        pq.add(arr);

        Map<Integer, List<int[]>> neigh = new HashMap();

        for (int i=0; i< times.length; i++) {
            int node = times[i][0];
            int nodeneigh = times[i][1];
            int dist = times[i][2];

            if (neigh.containsKey(node)) {
                List<int[]> neighbors = neigh.get(node);
                int[] edge = {nodeneigh, dist};
                neighbors.add(edge);
            } else {
                List<int[]> neighbors = new ArrayList();
                int[] edge = {nodeneigh, dist};
                neighbors.add(edge);
                neigh.put(node, neighbors);
            }
        }

        Set<Integer> visited = new HashSet();

        while (!pq.isEmpty()) {
            int[] poppedArr = pq.poll();
            
            int node = poppedArr[0];
            int dist = poppedArr[1];

            if (visited.contains(node)) continue;

            visited.add(node);

            if (!neigh.containsKey(node)) continue;

            List<int[]> nodeNeighbors = neigh.get(node);

            for (int i=0; i< nodeNeighbors.size(); i++) {
                int[] edgeNeighbor = nodeNeighbors.get(i);
                int n1 = edgeNeighbor[0];
                int d = edgeNeighbor[1];

                if (fdist[node] + d < fdist[n1]) {
                    fdist[n1] = fdist[node] + d;
                }

                int[] newArr = {n1, fdist[n1]};
                pq.add(newArr);

            } 
        }
        int maxTime = Integer.MIN_VALUE;
        for (int i=1; i<= n; i++) {
            if (fdist[i] == Integer.MAX_VALUE) return -1;

            if (fdist[i] > maxTime) maxTime = fdist[i];
        }

        return maxTime;
    }
}
