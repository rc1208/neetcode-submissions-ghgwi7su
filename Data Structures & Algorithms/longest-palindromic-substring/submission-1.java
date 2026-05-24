class Solution {
    public String longestPalindrome(String s) {
        String maxStr="";
        int maxLen=-1;
        int left, right;

        for (int i=0; i<s.length(); i++) {
            // odd length
            left=i; right=i;
            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                    maxStr = s.substring(left, right+1);
                }
                left--;
                right++;
            }

            // even length

            left=i; right=left+1;
            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (maxLen < right - left + 1) {
                    maxLen = right - left + 1;
                    maxStr = s.substring(left, right+1);
                }
                left--;
                right++;
            }

        }

        


        return maxStr;

    }
}
