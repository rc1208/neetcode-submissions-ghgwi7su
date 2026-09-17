class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0;
        int maxWeight = Integer.MIN_VALUE;
        for (int i=0; i< weights.length; i++) {
            if (weights[i] > maxWeight) maxWeight = weights[i];
            sum += weights[i];
        }

        int left = maxWeight;
        int right = sum;

        while (left < right) {
            int mid = left + (right - left)/2;

            if(canCapacity(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canCapacity(int[] weights, int days, int capacity) {
        int sum=0;
        int daysNeeded=1;
        for (int i=0; i< weights.length; i++) {
            sum += weights[i];
            if (sum > capacity) {
                daysNeeded++;
                if (daysNeeded > days) return false;
                sum=weights[i];
            }
        }

        return daysNeeded<=days;

    }
}

/*
weights=[1,5,4,4,2,3]
days=3

l = 5, r = 19
m = 12
[1,5,4][4,2,3]
r = 11
m = 8
[1,5][4,4][2,3]
l=5, r=7
m=6
[1,5][4][4,2][3]

*/

// weights = [2,4,6,1,3,10], days = 4
// capacity -> [min, max] -> [max(weights), sum(weights)] -> [10, 26]
// mid -> (1+26)//2 -> 13
// [2,4] [6,1,3] [10]