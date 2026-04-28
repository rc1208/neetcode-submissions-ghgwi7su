class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, List<Integer>> map = new HashMap();

        for (int i=0; i< routes.length; i++) {
            int bus = i;
            for (int j=0; j< routes[i].length; j++) {
               int stop = routes[i][j];

               if (map.containsKey(stop)) {
                    List<Integer> l = map.get(stop);
                    l.add(bus);
               } else {
                    List<Integer> l = new ArrayList();
                    l.add(bus);
                    map.put(stop, l);
               }
            }
        }


        // for (int key: map.keySet()) {
        //     System.out.println("key=" + key);
        //     List<Integer> l = map.get(key);
        //     for (int i=0; i<l.size(); i++) {
        //         System.out.print(l.get(i) + " ");
        //     }
        //     System.out.println();
        // }

        int res=0;

        Deque<Integer> q = new ArrayDeque();

        q.addLast(source);

        Set<Integer> seen = new HashSet();
        Set<Integer> visitedBus = new HashSet<>();

        while (!q.isEmpty()) {
            int size = q.size();

            for (int j=0; j<size; j++) {
                Integer poppedStop = q.removeFirst();
                seen.add(poppedStop);

                if (poppedStop == target) return res;


                if (map.containsKey(poppedStop)) {
                    List<Integer> buses = map.get(poppedStop);
                    for (int k=0; k< buses.size(); k++) {
                        int bus = buses.get(k);
                        if (visitedBus.contains(bus)) continue;
                        visitedBus.add(bus);
                        int[] nextStops = routes[bus];
                        for (int b=0; b<nextStops.length; b++) {
                            if (!seen.contains(nextStops[b])) q.addLast(nextStops[b]);
                        }
                    }
                } else {
                    continue;
                }
                
            }
            res++;
        }

        return -1;
    }
}