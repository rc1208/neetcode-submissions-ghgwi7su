class MyStack {
    Deque<Integer> q;
    public MyStack() {
        q = new ArrayDeque();
    }
    
    public void push(int x) {
        q.addLast(x);
    }
    
    public int pop() {
        int size = q.size();
        int count = 0;

        while (count < size-1) {
            int poppedElem = q.removeFirst();
            q.addLast(poppedElem);
            count++;
        }

        return q.removeFirst();
    }
    
    public int top() {
        int size = q.size();

        int count = 0;

        while (count < size-1) {
            int poppedElem = q.removeFirst();
            q.addLast(poppedElem);
            count++;
        }
        int top = q.removeFirst();
        q.addLast(top);
        return top;

    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */


 /*
q1 -> front [ 1 2 3 ] rear

pop()
int size = q.size()

while (counter < size)
    q.removeFirst() -> 1
    add 1 to end 
    q.removeFirst() -> 2
    add 2 to end

return 3

push()
q.addLast()






 */