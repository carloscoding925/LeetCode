package Java.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94_TreeInorderTraversal {
    public static void main(String[] args) {
        System.out.println("#94 - Binary Tree Inorder Traversal");

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println("Recursive Approach: " + inorderTraversalRecursive(root).toString());
        System.out.println("Iterative Approach: " + inorderTraversalIterative(root).toString());

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

    private static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        inorderHelper(node.left, result);
        result.add(node.val);
        inorderHelper(node.right, result);
    }

    private static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }

        return result;
    }
}