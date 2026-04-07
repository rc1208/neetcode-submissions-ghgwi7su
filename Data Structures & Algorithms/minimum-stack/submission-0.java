class MinStack {
    Deque<int[]> deq;
    public MinStack() {
        deq = new LinkedList();
    }
    
    public void push(int val) {
        if (deq.size() == 0) {
            int insert[] = new int[2];
            insert[0] = val;
            insert[1] = val;
            deq.addFirst(insert);
        } else {
            int insert[] = new int[2];
            insert[0] = val;
            insert[1] = Math.min(val, deq.peek()[1]);
            deq.addFirst(insert);
        }
    }
    
    public void pop() {
        if (deq.size() == 0) return;

        int[] popped = deq.removeFirst();

    }
    
    public int top() {
        if (deq.size() == 0) return -1;

        int[] popped = deq.peekFirst();

        return popped[0];
    }
    
    public int getMin() {
        if (deq.size() == 0) return -1;

        int[] popped = deq.peekFirst();

        return popped[1];
    }
}
