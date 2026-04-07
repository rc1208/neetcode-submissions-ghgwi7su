class Solution {
    public int maxArea(int[] heights) {
        int left =0;
        int right=heights.length-1;
        int maxArea = Integer.MIN_VALUE;

        while (left < right) {
            
           

            if (heights[left] <= heights[right]) {
                int area = (right - left) * Math.abs(heights[left]);
                maxArea = Math.max(maxArea, area);
                left++;
            } else {
                int area = (right - left) * Math.abs(heights[right]);
                maxArea = Math.max(maxArea, area);
                right--;
            }
            
        }

        return maxArea;
    }
}
