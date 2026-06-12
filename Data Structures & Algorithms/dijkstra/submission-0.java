class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        Map<Integer, Integer> map = new HashMap();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[] start = {0, src};
        pq.add(start);

        int[] dist = new int[n];
        for (int i=0; i<n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;


        

        while (!pq.isEmpty()) {
            int[] poppedNode = pq.poll();

            int distance = poppedNode[0];
            int node = poppedNode[1];

        

            if (distance > dist[node]) continue;

            for (int i=0; i<edges.size(); i++) {

                if (edges.get(i).get(0) == node) {
                    int neigh = edges.get(i).get(1);
                    int weight = edges.get(i).get(2);
                    if (distance + weight < dist[neigh]) {
                        dist[neigh] = distance + weight;
                        pq.add(new int[]{dist[neigh], neigh});
                    }
                }
            }
        }

        for (int i=0; i<n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                map.put(i, -1);
            } else {
                map.put(i, dist[i]);
            }
        }


        return map;
    }  
}
