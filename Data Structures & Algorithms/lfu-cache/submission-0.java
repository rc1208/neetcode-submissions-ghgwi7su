class LFUCache {
    int ts;
    int capacity;
    Map<Integer, Node> map;
    public LFUCache(int capacity) {
        this.ts=0;
        this.capacity = capacity;
        map = new HashMap();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node node = map.get(key);
        int val = node.val;
        node.freq = node.freq+1;
        node.ts = ts+1;
        ts++;

        return val;
    }
    
    public void put(int key, int value) {
        if (capacity <=0) return;
        ts++;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            node.freq= node.freq+1;
            node.ts = ts;
            
            return;
        }
        //evict
        if (map.size() >= capacity) {
            int minTs = Integer.MAX_VALUE;
            int minFreq = Integer.MAX_VALUE;
            int keyToBeRemoved = -1;
            for (int k: map.keySet()) {
                Node node = map.get(k);

                if (node.freq < minFreq ||
                 (node.freq == minFreq && node.ts < minTs)) {
                    
                    minFreq = node.freq;
                    minTs = node.ts;
                    keyToBeRemoved = k;
                 }
            }
            map.remove(keyToBeRemoved);
        }

        map.put(key, new Node(value, 1, ts));
    }
}


class Node {
    int val;
    int freq;
    int ts;

    public Node(int val, int freq, int ts) {
        this.val = val; this.freq=freq; this.ts = ts;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */