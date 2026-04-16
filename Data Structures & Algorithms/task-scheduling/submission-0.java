class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap();
        char maxCh = 'A';
        int maxCount = Integer.MIN_VALUE;
        for (int i=0; i< tasks.length; i++) {
            char ch = tasks[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            int count = map.get(ch);
            if (count > maxCount) {
                maxCount = count;
                maxCh = ch;
            }
        }

        int counter = 0;
        int currentTime = 0;
        

        PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> a.time - b.time);

        for (char ch: map.keySet()) {
            pq.add(new Data(ch, 0));
        }
        

        while (counter < tasks.length) {
            if (pq.size() == 0) break;
            Data peeked = pq.peek();

            if (peeked.time > currentTime) {
                currentTime++;
                continue;
            }


            Data popped = pq.poll();
            System.out.println(popped.ch + " " + popped.time);

            char ch = popped.ch;
            int time = popped.time;
            int newTime = time + n + 1;

            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) != 0) {
                pq.add(new Data(ch, newTime));
            }
        
            counter++;
            currentTime++;
        }

        return currentTime;
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
