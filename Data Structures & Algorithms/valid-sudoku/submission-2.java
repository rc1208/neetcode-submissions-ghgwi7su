class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> map = new HashMap();
        // rows and cols
        for (int i=0; i<9; i++) {
            String rStr = "r" + i;
            String cStr = "c" + i;
            map.put(rStr, new HashSet());
            map.put(cStr, new HashSet());
        }
        // 00, 01, 02, 10, 11, 12, 20, 21, 22
        for (int i=0; i<=2; i++) { 
            for (int j=0; j<=2; j++) {
                String boxStr = String.valueOf(i) + String.valueOf(j);
                map.put(boxStr, new HashSet());
            }
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char ch = board[i][j];

                if (ch == '.') continue;

                String rStr = "r" + i;
                Set<Character> rowSet = map.get(rStr);

                if (rowSet.contains(ch)) return false;
                else rowSet.add(ch);

                String cStr = "c" + j;
                Set<Character> colSet = map.get(cStr);

                if (colSet.contains(ch)) return false;
                else colSet.add(ch);

                String boxStr = String.valueOf(i/3) + String.valueOf(j/3);

                Set<Character> boxSet = map.get(boxStr);

                if (boxSet.contains(ch)) return false;
                else boxSet.add(ch);

            }
        }
        return true;
    }
}
