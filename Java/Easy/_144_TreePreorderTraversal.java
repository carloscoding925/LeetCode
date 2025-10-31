package Java.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _144_TreePreorderTraversal {
    public static void main(String[] args) {
        System.out.println("#144 - Binary Tree Preorder Traversal - Easy");

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println("Recursive Approach: " + preorderTraversalRecursive(root).toString());
        System.out.println("Iterative Approach: " + preorderTraversalIterative(root).toString());

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

    private static List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        result.add(node.val);
        preorderHelper(node.left, result);
        preorderHelper(node.right, result);
    }

    private static List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            result.add(current.val);

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        return result;
    }
}
