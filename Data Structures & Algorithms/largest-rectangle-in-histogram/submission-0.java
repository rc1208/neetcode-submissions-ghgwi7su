class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] rightMin = new int[heights.length];
        Arrays.fill(rightMin, -1);

        Deque<Integer> st = new ArrayDeque();

        for (int i=0; i<heights.length; i++) {

            while (!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                int poppedIndex = st.removeFirst();
                rightMin[poppedIndex] = i;
            }

            st.addFirst(i);
        }

        int[] leftMin = new int[heights.length];
        Arrays.fill(leftMin, -1);

        Deque<Integer> st1 = new ArrayDeque();

        for (int j=heights.length-1; j>=0; j--) {

            while (!st1.isEmpty() && heights[j] < heights[st1.peek()]) {
                int poppedIndex = st1.removeFirst();
                leftMin[poppedIndex] = j;
            }

            st1.addFirst(j);
        }

        System.out.println(Arrays.toString(rightMin));
        System.out.println(Arrays.toString(leftMin));

        int maxArea = Integer.MIN_VALUE;


        for (int i=0; i<heights.length; i++) {
            int height = heights[i];
            int rightVal = rightMin[i];
            int leftVal = leftMin[i];

            if (rightVal == -1) rightVal = heights.length-1;
            else rightVal = rightVal-1;
            if (leftVal == -1) leftVal = 0;
            else leftVal = leftVal+1;

            // rightVal -= 1;
            // leftVal += 1;

            int area = height * (rightVal - leftVal + 1);
            System.out.println(area);

            maxArea = Math.max(maxArea, area);

        }

        return maxArea;

    }
}

/*
for any index with a given height, the largest rectangle that can be formed with that height
is bounded by the min (next smallest elem to left of index, next smallest elem to right of index)


*/
