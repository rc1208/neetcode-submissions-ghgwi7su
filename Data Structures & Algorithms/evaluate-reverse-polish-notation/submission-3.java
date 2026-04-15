class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> st = new LinkedList();
        int target=0;
        
        for (int i=0; i< tokens.length; i++) {
            String ch = tokens[i];
            System.out.println(ch);
           

            if (ch.equals("+") || ch.equals("-") ||
             ch.equals("*") || ch.equals("/")) {
                int firstElem = Integer.valueOf(st.removeFirst());
                int secondElem = Integer.valueOf(st.removeFirst());
                System.out.println(firstElem + " " + secondElem);
                
                switch(ch) {
                    case "+": target = (firstElem + secondElem); break;
                    case "-": target = (secondElem - firstElem); break;
                    case "*": target = (firstElem * secondElem); break;
                    case "/": target = (secondElem/firstElem); break;
                } 

                System.out.println("target=" + target);

                st.addFirst(String.valueOf(target));
            } else { 
                st.addFirst(ch);
            }

            
        }

        return Integer.valueOf(st.peek());
    }
}
