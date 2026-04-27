class Solution {
    public int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];

        for (int i=1; i<=edges.length; i++) {
            parent[i] = i;
        }

        for (int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            if (union(edge) == false) return edge;

            
        }

        return new int[2];


    }

    public int find(int node) {
        if (parent[node] == node) return node;

        return find(parent[node]);
    }

    public boolean union(int[] edge) {
        if (find(edge[0]) == find(edge[1])) return false;

        else {
            parent[find(edge[0])] = parent[find(edge[1])];
            return true;
        }
    }
}
