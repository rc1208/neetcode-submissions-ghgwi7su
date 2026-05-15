class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer, Double> map = new HashMap();

        for (int i=0; i<points.length; i++) {
            double distance = Math.sqrt(Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            map.put(i, distance);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Double.compare(map.get(b), map.get(a)));

        for (Integer key: map.keySet()) {
            pq.add(key);

            if (pq.size() > k) pq.poll();
        }

        int[][] ans = new int[k][2];
        int index = 0;
        while(!pq.isEmpty()) {
            Integer popIndex = pq.poll();
            int[] elem = new int[2];
            elem = points[popIndex];
            ans[index++] = elem;
        }

        return ans;

    }
}

/*
1. distance = [2, 2.82]
2. make map -> index: distance => 0: 2, 1: 2.82
3. make max_heap of size k based on values of hash map -> add each elem of map; if size > k, then pop
4. iterate through max_heap and append to ans

*/
