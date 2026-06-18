class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // maintain a min heap sorted by end time, so that we can remove
        // trips' capacity from totalCapacity once those trips' end time
        // become less than equal to current trip
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]); 

        // sort original trips array by start time
        Arrays.sort(trips, (a,b) -> Integer.compare(a[1], b[1]));

        int totalCapacity = 0;
        for (int i=0; i<trips.length; i++) {
            int[] trip = trips[i];
            int currentCap = trip[0];

            totalCapacity += currentCap;
            int start = trip[1];

            while (!pq.isEmpty() && pq.peek()[2] <= start) {
                int[] poppedTrip = pq.poll();
                totalCapacity -= poppedTrip[0];
            }

            if (totalCapacity > capacity) return false;

            pq.add(trip);

        }

        return true;
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
