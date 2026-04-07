class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }

        String newStr = sb.toString();
        System.out.println(newStr);

        int start = 0;
        int end = newStr.length()-1;

        while (start<=end) {
            char ch1 = Character.toLowerCase(newStr.charAt(start));
            char ch2 = Character.toLowerCase(newStr.charAt(end));
            System.out.println(start + " " + end);
            System.out.println(ch1 + " " + ch2);
            if (ch1 != ch2){
                
                return false;
            } 

            start++;
            end--;
        }

        return true;
    }
}
