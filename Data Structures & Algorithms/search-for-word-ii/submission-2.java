class Solution {
    List<String> ans = new ArrayList();
    Set<String> unique = new HashSet();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        

        for (int i=0; i<words.length; i++) {
            trie.addWord(words[i]);
        }

        // for (int i=0; i<words.length; i++) {
        //     System.out.println(trie.isWord(words[i]));
        // }
        for (int i=0; i< board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
                dfs(board, i, j, trie, new HashSet(), new StringBuilder());
            }
        }

        return ans;

    }

    public void dfs(char[][] board, int row, int col,
     Trie trie, Set<String> visited, StringBuilder str) {

        if (row < 0 || row == board.length || col < 0 || col == board[0].length) return;

        if (visited.contains(row + " " + col)) return;

        if (!trie.isPrefix(str.toString() + board[row][col])) return;

        visited.add(row + " " + col);
        str.append(board[row][col]);

        if (trie.isWord(str)) {
            StringBuilder copyStr = new StringBuilder(str);
            if (!unique.contains(copyStr.toString())) ans.add(copyStr.toString());
            unique.add(copyStr.toString());
        }

        dfs(board, row - 1, col, trie, visited, str);
        dfs(board, row + 1, col, trie, visited, str);
        dfs(board, row, col - 1, trie, visited, str);
        dfs(board, row, col + 1, trie, visited, str);

        str.deleteCharAt(str.length() - 1);
        visited.remove(row + " " + col);

    }
}

class Trie {
    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            } else {
                Node newNode = new Node();
                curr.children.put(ch, newNode);
                curr = curr.children.get(ch);
            }
            
        }

        curr.isWord = true;
    }

    public boolean isPrefix(String word) {
        Node curr = root;

        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public boolean isWord(StringBuilder wordSb) {
        String word = wordSb.toString();
        Node curr = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.children.containsKey(ch)) {
                // System.out.println("here " + ch);
                curr = curr.children.get(ch);
            } else {
                return false;
            }
            
        }

        return curr.isWord == true;
    }


}

class Node {
    Node node;
    Map<Character, Node> children;
    boolean isWord;

    public Node() {
        this.children = new HashMap();
        this.isWord = false;
    }
}
