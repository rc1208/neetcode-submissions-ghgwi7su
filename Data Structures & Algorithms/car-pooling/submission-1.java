class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // maintain a min heap sorted by end time, so that we can remove
        // trips' capacity from totalCapacity once those trips' end time
        // become less than equal to current trip
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.end - b.end); 

        // sort original trips array by start time
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));

        int totalCapacity = 0;
        for (int i=0; i<trips.length; i++) {
            int[] trip = trips[i];
            int currentCap = trip[0];

            totalCapacity += currentCap;
            int start = trip[1];

            while (!pq.isEmpty() && pq.peek().end <= start) {
                Point poppedTrip = pq.poll();
                totalCapacity -= poppedTrip.capacity;
            }

            if (totalCapacity > capacity) return false;

            pq.add(new Point(trip[0], trip[1], trip[2]));

        }

        return true;
    }
}

class Point {
    int capacity;
    int start;
    int end;

    public Point(int capacity, int start, int end) {
        this.capacity=capacity;
        this.start=start;
        this.end=end;
    }
}

// [[4,1,2],[3,2,4]]


/*
trips=[[3,2,7],[3,7,9],[8,3,9]]

[3,2,7] //3
[8,3,9] //3+8=11

7 ts -> subtract 
[3,7,9] //11-3=8


capacity=11







*/
