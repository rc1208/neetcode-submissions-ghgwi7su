class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> st = new ArrayDeque();

        for (int i=0; i<operations.length; i++) {
            String op = operations[i];

            switch(op) {
                case "+": 
                    Integer secondElem = st.removeFirst();
                    Integer firstElem = st.removeFirst();
                    Integer sum = firstElem + secondElem;
                    st.addFirst(firstElem);
                    st.addFirst(secondElem);
                    st.addFirst(sum);
                    break;
                case "D":
                    Integer el = st.peek();
                    Integer prod = el * 2;
                    st.addFirst(prod);
                    break;
                case "C":
                    st.removeFirst();
                    break;
                default:
                    st.addFirst(Integer.valueOf(op));   
            }
        }


        Iterator<Integer> it = st.iterator();

        int res = 0;

        while(it.hasNext()) {
            Integer val = it.next();
            res += val;
        }

        return res;
    }
}

/*
if number add to top of stack
if + peek first & 2nd elem, and add res to top of stack
if C, remove top
if D peek first & 2nd elem, and add res to top of stack

go through stack, and elems up to res
return res
*/