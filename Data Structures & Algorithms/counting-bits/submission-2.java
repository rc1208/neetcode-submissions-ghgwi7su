class Solution {
    public int[] countBits(int n) {
        // Logic: for given n, n can be represented as n//2 + last significant bit
        // ex: 9 => 9//2 = 4 (binary as 100) + 1 (LSB)
        if (n==0) {
            return new int[1];
        }
        int[] ans = new int[n+1];

        ans[0] = 0;
        ans[1] = 1;

        for (int i=2; i<=n; i++) {
            if (i%2 == 0) ans[i] = 0 + ans[i/2];
            else ans[i] = 1 + ans[i/2];
        }


        return ans;

    }
}
