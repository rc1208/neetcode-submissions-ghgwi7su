class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int maxLen = Integer.MIN_VALUE;
        String maxStr="";
        boolean noMatch = false;

        // for (int i=0; i<strs[0].length(); i++) {
        //     char currentCh = strs[0].charAt(i);

        //     prefix += currentCh; 
        //     noMatch = false;

        //     for (int j=1; j<strs.length; j++) {
        //         if (strs[j].length() - 1 < i) {
        //             noMatch = true;
        //             break;
        //         }
        //         if (currentCh != strs[j].charAt(i))  {
        //             noMatch = true;
        //             break;
        //         }
        //     }

        //     if (!noMatch) {
        //         System.out.println(prefix);
        //         if (maxLen < prefix.length()) {
        //             maxLen = prefix.length();
        //             maxStr = prefix;
        //         }
               
        //     } else {
        //         prefix = "";
        //     }

            
        // }

        
        for (int i=0; i< strs[0].length(); i++) {
            char currentCh = strs[0].charAt(i);
            boolean doesNotMatch = false;
            for (int j=1; j< strs.length; j++) {
                if (strs[j].length() - 1 < i) {
                    doesNotMatch = true;
                    break;
                }

                if (currentCh != strs[j].charAt(i))  {
                    doesNotMatch = true;
                    break;
                }  
            }

            if(!doesNotMatch) {
                prefix = prefix + currentCh;   
            } else {
                break;
            }


        }

        

        return prefix;
    }
}

/*
1. prefix = strs[0][0], check all strings, if char match, continue else prefix="", i+=1
2. prefix+=strs[0][0]

*/