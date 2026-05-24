class Solution {
    Map<Integer, Boolean> memo = new HashMap();
    public boolean wordBreak(String s, List<String> wordDict) {
        int index=0;
        return findWordBreak(s, index, wordDict);

        
    }

    public boolean findWordBreak(String s, int index, List<String> wordDict) {
        if (index == s.length()) {
            memo.put(index, true);
            return true;
        } 

        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        for (int j=0; j< wordDict.size(); j++) {
            String word = wordDict.get(j);
            boolean result;
            
            if (index + word.length() <= s.length() && s.substring(index, index + word.length()).equals(word)) {
                if (findWordBreak(s, index + word.length(), wordDict)) {
                    memo.put(index, true);
                    return true;
                }
            }
        }
        memo.put(index, false);
        return false;
    }
}

/*
for w in words: 
    if w matches
     (i, i + w.len) then i+1
     found =true

if found == false return false
if i==len return true

*/
