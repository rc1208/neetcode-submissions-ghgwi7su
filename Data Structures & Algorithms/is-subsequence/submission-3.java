class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int j=0;
        for (int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);

            if (s.charAt(j) == ch) {
                j++;
                if (s.length() == j) return true;
            }
        }

        return false;
    }
}