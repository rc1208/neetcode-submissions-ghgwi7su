class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> st = new ArrayDeque(); //stack
        Map<Integer, Integer> map = new HashMap();

        int[] indexOfNextLargest = new int[nums2.length];
        Arrays.fill(indexOfNextLargest, -1);

        for (int i=0; i< nums2.length; i++) {

            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]) {
                int index = st.removeFirst();
                indexOfNextLargest[index] = i;
            }

            st.addFirst(i);
        }

        // System.out.println(Arrays.toString(indexOfNextLargest));

        for (int i=0; i< nums1.length; i++) {
            map.put(nums1[i], -1);
        }


        for (int i=0; i< nums2.length; i++) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], i);
            }
        }



        int[] ans = new int[nums1.length];
        int index=0;

        for (int i=0; i<nums1.length; i++) {
            int mappedIndex = map.get(nums1[i]);
            // System.out.println(mappedIndex);
            int nextIndex = indexOfNextLargest[mappedIndex];

            if (nextIndex == -1) ans[index++] = -1;
            else ans[index++] = nums2[nextIndex];
        }

        return ans;
    }
}