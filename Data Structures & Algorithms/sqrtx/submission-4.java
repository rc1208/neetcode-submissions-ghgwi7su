class Solution {
    public int mySqrt(int x) {
        if (x==0 || x==1) return x;

        int left=0,right=x/2;

        while (left <= right) {
            int mid = left + (right - left)/2;

            if ((long) mid*mid == x) return mid;

            if ((long) mid*mid < x) left = mid+1;
            else right = mid-1;
        }

        return left-1;
    }
}

/*
x=13

0 1 2 3 4 5 6

l=0
r=6
m=3

9 < 13

l=4, r=6
m=5

x=11

0 1 2 3 4 5

l=0, r=5
m=2

l=3, r=5
m=4

l=3,r=3
m=3

l=4,r=3

x=1
l=0 r=0
0

x=0

x=4

0 1 2
l=0,r=2
m=1

l=2,r=2


*/