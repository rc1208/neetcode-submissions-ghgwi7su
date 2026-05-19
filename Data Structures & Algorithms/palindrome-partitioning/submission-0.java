class Solution {
    List<List<String>> ans = new ArrayList();
    public List<List<String>> partition(String s) {
        int index = 0;
        backtrack(s, index, new ArrayList());
        return ans;
    }

    public void backtrack(String s, int index, List<String> l) {

        if (index == s.length()) {
            List<String> copyL = new ArrayList(l);
            ans.add(copyL);
            return;
        }

        for (int j=index; j< s.length(); j++) {
            String firstSubStr = s.substring(index, j+1);
            System.out.println(firstSubStr);
            if (isPalin(firstSubStr)) {
                l.add(firstSubStr);
                backtrack(s, j+1, l);
                l.remove(l.size() - 1);
            }
        }
    }


    public boolean isPalin(String s) {

        int l=0, r=s.length() - 1;

        while (l<r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}

