class Solution {
    List<String> ans = new ArrayList();
    public List<String> generateParenthesis(int n) {
        backtrack(new StringBuilder(), n, 0, 0);

        return ans;
    }

    public void backtrack(StringBuilder l, int n, int open, int close) {
        // System.out.println(n  + " " + open + " " + close + " " + l);
        if (n == open && n == close) {
            StringBuilder copy = new StringBuilder(l);
            ans.add(copy.toString());
            // System.out.println("added->" + copy);
            return;
        }

        if (open != n) {
            l.append("(");
            backtrack(l, n, open+1, close);
            l.deleteCharAt(l.length() - 1);
        }
        
        
        if (close < open) {
            l.append(")");
            backtrack(l, n, open, close+1);
            l.deleteCharAt(l.length() - 1);
        }

        
        
    }
}

/*
n=2
 ()(), (())
*/
