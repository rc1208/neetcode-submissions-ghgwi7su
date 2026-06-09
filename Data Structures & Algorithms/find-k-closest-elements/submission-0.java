class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int minIndex= -1;
        int minDiff = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; i++) {
            int diff = Math.abs(arr[i] - x);

            if (diff < minDiff) {
                minIndex = i;
                minDiff = diff;
            }
        }

        System.out.println("minIndex=" + minIndex);

        int left = minIndex - 1; // 1
        int right = minIndex + 1; // 3
        List<Integer> ans = new ArrayList();
        ans.add(arr[minIndex]);
        int count=1;
        while (count < k) {
            //if left goes out of bounds, just add everything from right
            if (left < 0) {
                while (count < k) {
                    ans.add(arr[right]);
                    count++;
                    right++;
                }
                break;
            }
            //if right goes out of bounds, just add everything from left
            if (right == arr.length) {
                while (count < k) {
                    ans.add(arr[left]);
                    count++;
                    left--;
                }
                break;
            }

            if (Math.abs(arr[left] - x) < Math.abs(arr[right] - x)) {
                ans.add(arr[left]);
                count++;
                left--;
            } else if (Math.abs(arr[left] - x) == Math.abs(arr[right] - x)) {
                ans.add(arr[left]);
                count++;
                left--;
            } else {
                ans.add(arr[right]);
                count++;
                right++;
            }
        }

        Collections.sort(ans);

        return ans;
    }
}


/*
[2,4,5,8] k=2, x=6
windows:
[2,4] -> minDiff = 2
[4,5] -> minDiff = 1
[5,8] -> minDiff = 1



2 - 6 = abs(-4) = 4
4 - 6 = 2
5 - 6 = 1
8 - 6 = 2


[2,3,4], k = 3, x = 1
[2,3,4]


*/