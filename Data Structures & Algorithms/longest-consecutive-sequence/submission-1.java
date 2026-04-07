class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length ==0) return 0;
        Set<Integer> set = new HashSet();

        for (int i=0; i< nums.length; i++) {
            set.add(nums[i]);
        }
        int maxLength = Integer.MIN_VALUE;

        for (int i=0; i< nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                System.out.println("starting at" + nums[i]);
                int len = 0;
                int currNum = nums[i];
                while (true) {
                    if (set.contains(currNum)) {
                        len++;
                        currNum++;
                    } else {
                        break;
                    }
                }

                maxLength = Math.max(maxLength, len);

            }
         }

         return maxLength;
    }
}
