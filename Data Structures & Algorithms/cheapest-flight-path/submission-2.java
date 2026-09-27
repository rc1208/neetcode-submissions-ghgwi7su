class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. Build Adjacency List
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] f : flights) {
            adj[f[0]].add(new int[]{f[1], f[2]}); // [destination, price]
        }

        // 2. Track minimum cost to reach each node
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        // Queue stores: [node, cost]
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int stops = 0;

        // 3. Process level-by-level up to k + 1 flights
        while (!queue.isEmpty() && stops <= k) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int u = curr[0];
                int cost = curr[1];

                for (int[] neighbor : adj[u]) {
                    int v = neighbor[0];
                    int price = neighbor[1];

                    // Prune paths that don't improve the cost
                    if (cost + price < minCost[v]) {
                        minCost[v] = cost + price;
                        queue.offer(new int[]{v, minCost[v]});
                    }
                }
            }
            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}