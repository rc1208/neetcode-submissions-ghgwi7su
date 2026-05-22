class Solution {
    public String decodeString(String s) {
        Deque<String> st = new ArrayDeque();

        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            // System.out.println(String.valueOf(ch));
            if (String.valueOf(ch).equals("]")) {
                // System.out.println("here");
                String subStr = "";
                while (!st.isEmpty() && !st.peekFirst().equals("[")) {
                    subStr = st.peekFirst() + subStr;
                    st.removeFirst();
                }
                if (!st.isEmpty() && st.peekFirst().equals("[")) {
                    st.removeFirst();
                }

                String number = "";
                while (!st.isEmpty() && Character.isDigit(st.peekFirst().charAt(0))) {
                    number = st.removeFirst() + number;
                }

                int numberInt = Integer.valueOf(number);

                String newSubStr="";
                for (int j=1; j<=numberInt; j++) {
                    newSubStr = newSubStr + subStr;
                }

                st.addFirst(newSubStr); 
            } else {
                st.addFirst(String.valueOf(ch));
            }
        }

        StringBuilder finalAns = new StringBuilder();

        while (!st.isEmpty()) {
            finalAns.insert(0, st.removeFirst());
        }

        return finalAns.toString();


    }
}

/*
3[a]2[bc]
aaabcbc

3[a2[c]]
3[acc]
accaccacc


st-> accaccacc
s = 3[a]2[bc]
st ->  aaa bcbc
substr = bcbc
if s[i] == ']':
 pop ch and append to subStr (subStr = ch + subStr) till ch != [,
 then pop [
 pop till number in reverse (stop when ch is not num)
 subStr * popCh => cc
 push above str to st


*/