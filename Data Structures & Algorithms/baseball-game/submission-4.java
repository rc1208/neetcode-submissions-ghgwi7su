class Solution {
    public int calPoints(String[] operations) {
        Deque<String> st = new ArrayDeque();


        for (int i=0; i< operations.length; i++) {
            String ch = operations[i];

            if (ch.equals("+")) {
                String num1 = st.removeFirst();
                String num2 = st.removeFirst();
                int sum = Integer.valueOf(num1) + Integer.valueOf(num2);
                st.addFirst(num2);
                st.addFirst(num1);
                st.addFirst(String.valueOf(sum));   
            }

            else if (ch.equals("D")) {
                String num1 = st.removeFirst();
                int mul = Integer.valueOf(num1) * 2;
                System.out.println("mul--> " + String.valueOf(mul));
                st.addFirst(num1);
                st.addFirst(String.valueOf(mul)); 
            }

            else if (ch.equals("C")) {
                st.removeFirst();
            } else {
                st.addFirst(ch);
            }

        }
        
        int sum=0;
        while (!st.isEmpty()) {
            String num = st.removeFirst();
            System.out.println(num);
            sum += Integer.valueOf(num);
        }

        return sum;
    }
}