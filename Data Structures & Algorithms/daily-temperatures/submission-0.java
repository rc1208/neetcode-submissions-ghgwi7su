class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> st = new ArrayDeque();
        int[] ans = new int[temperatures.length];

        for (int i=0; i< temperatures.length; i++) {
            while (!st.isEmpty() && st.peekFirst()[0] < temperatures[i]) {
                int[] pop = st.removeFirst();
                int temp = pop[0];
                int index = pop[1];
                ans[index] = i - index;
            }

            st.addFirst(new int[]{temperatures[i], i});
        }


        return ans;
    }
}

// st -> 38,1 30,2 36,3 
