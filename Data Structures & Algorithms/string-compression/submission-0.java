class Solution {
    public int compress(char[] chars) {
        int k=0;
        int i=1;
        char prevChar = chars[0];
        int count=1;
        while (i < chars.length) {
            char ch = chars[i];

            if (prevChar == ch) {
                count++;
                i++;
                continue;
            } else {
                String countStr = String.valueOf(count);
                
                if (count == 1) {
                    chars[k++] = prevChar;
                } else {
                    chars[k++] = prevChar;

                    for (int j=0; j<countStr.length(); j++) {
                        chars[k++] = countStr.charAt(j);
                    }
                }
                
                

                count=0;
                count++;
                i++;
                prevChar = ch;
            }

        }
        System.out.println(count);
        if (count == 1) {
            chars[k++] = prevChar;
        } else {
            String countStr = String.valueOf(count);
            chars[k++] = prevChar;

            for (int j=0; j<countStr.length(); j++) {
                chars[k++] = countStr.charAt(j);
            }
        }
        

        System.out.println(k);

        return k;
    }
}