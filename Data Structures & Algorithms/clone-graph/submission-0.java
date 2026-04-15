/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap();
        Set<Node> visited = new HashSet();

        Deque<Node> q = new LinkedList();

        q.addLast(node);


        while (!q.isEmpty()) {
            Node poppedNode = q.removeFirst();
            System.out.println(poppedNode.val);

            visited.add(poppedNode);

            Node newNode;

            if (map.containsKey(poppedNode.val)) {
                newNode = map.get(poppedNode.val);
            } else {
                newNode = new Node(poppedNode.val);
                map.put(poppedNode.val, newNode);
            }

            List<Node> neighbors = poppedNode.neighbors;

            List<Node> newNeighborsList = new ArrayList();

            for (int i=0; i<neighbors.size(); i++) {
                Node neighbor = neighbors.get(i);
                Node newNeighbor;

                if (map.containsKey(neighbor.val)) {
                    newNeighbor = map.get(neighbor.val);
                } else {
                    newNeighbor = new Node(neighbor.val);
                    map.put(neighbor.val, newNeighbor);
                }

                newNeighborsList.add(newNeighbor);

                if (!visited.contains(neighbor)) q.addLast(neighbor);
            }

            newNode.neighbors = newNeighborsList;
        }

        // for (int key: map.keySet()) {
        //     System.out.println("key=" + key);
        //     for (int i=0; i< map.get(key).neighbors.size(); i++) {
        //         System.out.print(map.get(key).neighbors.get(i).val + " ");
        //     }
        // }

        return map.get(node.val);
    }
}