class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int stops = 0;
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] flight : flights) {
            adjList.computeIfAbsent(flight[0], x -> new ArrayList<>()).add(new int[]{flight[1], flight[2]});
        }

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[src] = 0;
        
        q.addLast(src);

        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            int[] tmpDist = Arrays.copyOf(minDist, n);

            for (int j = 0; j < size; j++) {
                int poppedNode = q.removeFirst();
                if (!adjList.containsKey(poppedNode)) continue;

                for (int[] neighbor : adjList.get(poppedNode)) {
                    int neigh = neighbor[0];
                    int nd = neighbor[1];

                    if (minDist[poppedNode] != Integer.MAX_VALUE && minDist[poppedNode] + nd < tmpDist[neigh]) {
                        tmpDist[neigh] = minDist[poppedNode] + nd;
                        q.addLast(neigh);
                    }
                }
            }
            
            // Move inside the while loop!
            minDist = tmpDist;
            stops++;
        }

        return minDist[dst] == Integer.MAX_VALUE ? -1 : minDist[dst];
    }
}