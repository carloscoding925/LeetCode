package Java.Hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _297_SerializeBST {
    public static void main(String[] args) {
        System.out.println("#297 - Serialize and Deserialize Binary Tree - Hard");

        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        String serialized = serialize(root);
        TreeNode original = deserialize(serialized);

        System.out.println("Serialized Tree: " + serialized);

        return;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private static void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null,");
            return;
        }

        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    private static TreeNode deserialize(String data) {
        String[] values = data.split(",");
        List<String> list = new LinkedList<>(Arrays.asList(values));
        return deserializeHelper(list);
    }

    private static TreeNode deserializeHelper(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }

        String val = list.remove(0);
        if (val.equals("null")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(list);
        node.right = deserializeHelper(list);

        return node;
    }
}
