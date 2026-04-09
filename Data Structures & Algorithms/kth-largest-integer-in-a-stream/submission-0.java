class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        this.pq = new PriorityQueue();
        for (int n: nums) {
            this.pq.add(n);
        }
        this.k = k;  
        // create a min heap, then reduce the size to k. This way only the top k elems will remain in the heap
        while (pq.size() > k) {
            pq.poll();
        }      
    }
    
    public int add(int val) {
        pq.add(val);

        if (pq.size() > this.k) pq.poll();

        return pq.peek();
    }
}
