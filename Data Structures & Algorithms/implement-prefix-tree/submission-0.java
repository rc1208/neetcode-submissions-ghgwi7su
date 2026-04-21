class PrefixTree {
    Node root;
    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node current = root;

        for (int i=0; i<word.length();i++) {
            char ch=word.charAt(i);
            
            if (current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else {
                Node newNode = new Node();
                current.children.put(ch, newNode);
                current = current.children.get(ch);
            }
        }

        current.isWord = true;
    }

    public boolean search(String word) {
        Node current = root;

        int count = 0;
        for(int w=0; w< word.length(); w++) {
            char ch = word.charAt(w);
            count++;

            if (!current.children.containsKey(ch)) return false;

            current = current.children.get(ch);

        }

        if (count == word.length() && current.isWord == true) return true;
        else return false;
    }

    public boolean startsWith(String prefix) {
        Node current = root;

        int count = 0;
        for(int w=0; w< prefix.length(); w++) {
            char ch = prefix.charAt(w);
            count++;

            if (!current.children.containsKey(ch)) return false;

            current = current.children.get(ch);
        }

        if (count == prefix.length()) return true;
        else return false;

    }
}

class Node {
    Map<Character, Node> children;
    boolean isWord;

   
    public Node() {
        this.children = new HashMap();
        this.isWord = false;
    }
}
