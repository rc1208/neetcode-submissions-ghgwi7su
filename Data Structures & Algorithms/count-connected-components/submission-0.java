class Solution {
    Set<Integer> visited = new HashSet();
    int count = 0;
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i=0; i<n; i++) {
            map.put(i, new ArrayList());
        }

        for (int i=0; i<edges.length; i++) {
            int[] e = edges[i];
            List<Integer> l_0 = map.get(e[0]);
            l_0.add(e[1]);

            List<Integer> l_1 = map.get(e[1]);
            l_1.add(e[0]);
        }

        

        for (int i=0; i<n; i++) {
            if (!visited.contains(i)) {
                doBFS(i, map);
                count++;
            }
            
        }

        return count;
    }

    public void doBFS(int edge, Map<Integer, List<Integer>> map) {
        Deque<Integer> q = new LinkedList();
        q.addLast(edge);

        while(!q.isEmpty()) {
            Integer poppedNode = q.removeFirst();
            visited.add(poppedNode);

            List<Integer> neighbors = map.get(poppedNode);

            for (int i=0; i<neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                if (!visited.contains(neighbor)) q.addLast(neighbor);
            }
        }
    }
}
