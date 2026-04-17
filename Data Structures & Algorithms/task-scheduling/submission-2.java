class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();

        for (int i= 0; i<tasks.length; i++) {
            char ch = tasks[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // for (char key: map.keySet()) System.out.println(key +  " " + map.get(key));
        // max heap based on freq
        PriorityQueue<Character> pq = new PriorityQueue((a,b) -> map.get(b) - map.get(a));

        // at time t0, add all to heap
        for (char key: map.keySet()) {
            pq.add(key);
        }

        // queue to hold tasks that are equal or bigger than current timestamp
        Deque<Data> q = new LinkedList();
        int time = 1;
        


        while (true) {
           System.out.println("time=" + time);
          
            // also, for given time t, check if there are items in Q
            // that can be added to heap for scheduling
            while (true) {
                if (!q.isEmpty() && q.peekFirst().time <= time) {
                    Data removedItem = q.removeFirst();
                    System.out.println("removed from Q" + removedItem.ch);
                    pq.add(removedItem.ch);
               } else break; 
            }
            // if there are items in heap, that means those tasks can be scheduled
            // at given time
            if (!pq.isEmpty()) {
                char poppedTask = pq.poll();
                System.out.println(poppedTask);
                map.put(poppedTask, map.get(poppedTask) - 1);
                // only add to q if the count of task is not 0
                if (map.get(poppedTask) != 0) {
                    int newTime = time + n + 1;
                    q.addLast(new Data(poppedTask, newTime));
                }
                
            }
            
            
            // System.out.println("pq head->" + pq.peek());
            // System.out.println("q head->" + q.peekFirst());

            if (pq.isEmpty() && q.isEmpty()) break;
            time++;
        }



        return time;

    }
}

class Data {
    char ch;
    int time;

    public Data(char ch, int time) {
        this.ch = ch;
        this.time = time;
    }
}


