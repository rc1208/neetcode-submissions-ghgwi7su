class Solution {
    public List<Integer> partitionLabels(String s) {
        
        Map<Character, Integer> map = new HashMap();
        for (int i=s.length()-1; i >=0; i--) {
            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                map.put(ch, i);
            }
        }

        int left=0,right=0;

        List<Integer> ans = new ArrayList();


        while(left < s.length()) {
            int boundaryLeft = left;
            for (int i=left; i<=right; i++) {
                char chLeft= s.charAt(i);
                right = Math.max(right, map.get(chLeft));
            }
            ans.add(right - boundaryLeft + 1);
            // System.out.println(right - boundaryLeft + 1);

            right = right+1;
            left = right;
            // System.out.println("left=" + left + " right= " + right);
        }


        return ans;
    }
}
