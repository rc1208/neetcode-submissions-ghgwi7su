class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> arr = new ArrayList();
        int right = nums.length-1;

        int rotation;
        if (nums.length > k) {
            rotation = k;
        } else {
            rotation = k%nums.length;
        }
        System.out.println(rotation);

        for (int i=0; i< rotation; i++) {
            arr.add(0, nums[right]);
            right--;
        }

        for (int i=0; i<nums.length-rotation; i++) {
            arr.add(nums[i]);
        }

        System.out.println(arr);

        for (int i=0; i<nums.length; i++) {
            nums[i] = arr.get(i);
        }
    }
}

/*

[1,2,3,4,5,6,7,8]

l=0

*/