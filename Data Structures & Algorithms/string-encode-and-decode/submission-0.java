class Solution {
    // 5#Hello#6World6#Walker
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i< strs.size(); i++) {
            String word = strs.get(i);
            sb.append(word.length());
            sb.append("#");
            sb.append(word);
        }
        System.out.println(sb.toString());

        return sb.toString();
    }

    public List<String> decode(String str) {

        List<String> ans = new ArrayList();
        

        int count = 0;
        while (count< str.length()) {
            StringBuilder strCount = new StringBuilder();

            while (str.charAt(count) != '#') {
                strCount.append(str.charAt(count));
                count++;
            }

            System.out.println("strCount -->" + strCount);

            int strCountInt = Integer.parseInt(strCount.toString());
            count++; // move to next str
            ans.add(str.substring(count, count + strCountInt));

            count = count + strCountInt;
        }

        return ans;
    }
}
