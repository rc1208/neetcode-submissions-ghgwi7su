class Solution {
    public boolean exist(char[][] board, String word) {
        

        for (int i=0; i< board.length; i++) {
            for (int j=0; j< board[0].length; j++) {
                char ch = board[i][j];

                if (ch == word.charAt(0)) {
                    Set<String> visited = new HashSet();
                    boolean res = doDfs(board, i, j, word, visited, 0);
                    if (res) return true;
                }
            }
        }

        return false;
    }

    public boolean doDfs(char[][] board, int row, int col, String word, Set<String> visited, int index) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length) return false;

        if (visited.contains(row + " " + col)) return false;

        if (index == word.length()) return false;

        if (board[row][col] != word.charAt(index)) return false;

        visited.add(row + " " + col);
        System.out.println(row + " " + col + " " + index);
        if (board[row][col] == word.charAt(index) && index == word.length() - 1) return true;

        

        boolean res = doDfs(board, row - 1, col, word, visited, index+1) ||
        doDfs(board, row + 1, col, word, visited, index+1) ||
        doDfs(board, row, col - 1, word, visited, index+1) ||
        doDfs(board, row, col + 1, word, visited, index+1);
        

        visited.remove(row + " " + col);

        return res;
    }
}
