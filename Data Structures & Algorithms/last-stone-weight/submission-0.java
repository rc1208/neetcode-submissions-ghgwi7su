class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b-a));

        for (int s: stones) pq.add(s);

        while (true) {
            if (pq.size() <= 1) break;
            int elem1 = pq.poll();
            int elem2 = pq.poll();

            if (elem1 == elem2) continue;

            if (elem2>elem1) pq.add(elem2-elem1);
            else pq.add(elem1-elem2);
        }

        return pq.size() == 0 ? 0 : pq.peek(); 
    }
}
