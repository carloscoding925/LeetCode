package Java.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _133_CloneGraph {
    public static void main(String[] args) {
        System.out.println("#133 - Clone Graph - Medium");

        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);

        one.neighbors = new ArrayList<>(Arrays.asList(two, four));
        three.neighbors = new ArrayList<>(Arrays.asList(two, four));
        two.neighbors = new ArrayList<>(Arrays.asList(one, three));
        four.neighbors = new ArrayList<>(Arrays.asList(one, three));

        Node deepCopy = cloneGraph(one);

        return;
    }

    private static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            this.val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            this.val = _val;
            this.neighbors = _neighbors;
        }
    }

    private static Map<Node, Node> visited = new HashMap<>();

    private static Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
    }
}
