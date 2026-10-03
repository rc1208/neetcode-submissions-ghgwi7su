class MedianFinder {
    // store the larger half of stream
    PriorityQueue<Integer> minHeap;
    // store the smaller half of stream
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>((a,b) -> a - b);
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        // add to maxHeap
        maxHeap.add(num);
        
        // check if top of maxHeap < top of minHeap
        if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
            int polledElem = maxHeap.poll();
            minHeap.add(polledElem);
        }

        // balance out both the heaps
        if (maxHeap.size() > minHeap.size() + 1) {
            int polledElem = maxHeap.poll();
            minHeap.add(polledElem);
        }

        if (minHeap.size() > maxHeap.size() + 1) {
            int polledElem = minHeap.poll();
            maxHeap.add(polledElem);
        }

    }
    
    public double findMedian() {
        int size = minHeap.size() + maxHeap.size();
        // System.out.println("size -->" + minHeap.size() + " " + maxHeap.size());

        if (size %2 == 0) {
            // System.out.println(minHeap.peek() + " " + maxHeap.peek());
            return (minHeap.peek() + maxHeap.peek())/2.0;
        } else {
            if (minHeap.size() > maxHeap.size()) return minHeap.peek();
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
        }

        return 0.0;
    }
}
