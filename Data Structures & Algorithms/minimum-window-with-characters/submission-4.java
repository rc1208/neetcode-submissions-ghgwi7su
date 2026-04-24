class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapT = new HashMap();

        for (int i=0; i< t.length(); i++) {
            char ch = t.charAt(i);
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }

        int totalMatches= mapT.size();

        int start=0;
        int res=Integer.MAX_VALUE;
        String finalResult="";

        Map<Character, Integer> mapS = new HashMap();

        for (int end=0; end<s.length(); end++) {
            char endCh = s.charAt(end);
            System.out.println("endCh=" + endCh + "startCh=" + start);
            mapS.put(endCh, mapS.getOrDefault(endCh, 0) + 1);

            
            // keep shrinking the window as long as it's safe
            while (doCountMatches(mapS, mapT)) {

                if (res > (end-start+1)) {
                        res = end-start+1;
                        finalResult = s.substring(start, start + res);
                }

                // System.out.println("doCountMatches true for = " + s.substring(start, start + res));

                char startCh = s.charAt(start);
                mapS.put(startCh, mapS.get(startCh) - 1);
                start++; 
            }
        }

        // System.out.println("finalResult=" + finalResult);
        return finalResult;
    }

    public boolean doCountMatches(Map<Character, Integer> mapS, Map<Character, Integer> mapT) {
        boolean match = false;

        for (char k: mapT.keySet()) {
            if (!mapS.containsKey(k)) return false;
            if (mapS.get(k) < mapT.get(k)) return false;
        }

        return true;
    }
}

// DOBECODEBANC
// A: 1, B: 2: , C: 2 
