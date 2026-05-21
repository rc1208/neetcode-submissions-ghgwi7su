class FreqStack {
    int maxFreq;
    Map<Integer, Integer> map;
    Map<Integer, Deque<Integer>> mapFreqToElem;
    public FreqStack() {
        maxFreq = -1;
        map = new HashMap();
        mapFreqToElem = new HashMap();
    }
    
    public void push(int val) {
        if (map.containsKey(val)) {
            map.put(val, map.get(val)+1);
        } else {
            map.put(val, 1);
        }

        if (map.get(val) > maxFreq) maxFreq = map.get(val);

        if (mapFreqToElem.containsKey(map.get(val))) {
            mapFreqToElem.get(map.get(val)).addFirst(val);
        } else {
            Deque<Integer> st = new ArrayDeque();
            st.addFirst(val);
            mapFreqToElem.put(map.get(val), st);
        }
    }
    
    public int pop() {
        int key = maxFreq;

        int poppedElem = mapFreqToElem.get(key).removeFirst();
        if (mapFreqToElem.get(key).size() == 0) {
            maxFreq -= 1;
        }

        map.put(poppedElem, map.get(poppedElem) - 1);


        return poppedElem;
    }
}

/*
map -> holds counts of each val
maxCount -> holds the highest freq
mapFreqToElem -> holds freq as key and stack of elems as value

One thing to note is to observe that we need to treat each elem (duplicates) as individuals.
mapFreqToElem holds groups of elems that have the same freq
For example: data stream -> [5,4,5,3,4,2,5,3]
then groups are:
 1: [5,4, 3,2]
 2: [5,4,3]
 3: [5]

*/

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */