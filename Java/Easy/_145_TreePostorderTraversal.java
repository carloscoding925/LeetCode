package Java.Easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _145_TreePostorderTraversal {
    public static void main(String[] args) {
        System.out.println("#145 - Binary Tree Postorder Traversal - Easy");

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println("Recursive Approach: " + postorderTraversalRecursive(root).toString());
        System.out.println("Iterative Approach: " + postorderTraversalIterative(root).toString());

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

    private static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private static void postorderHelper(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }

        postorderHelper(node.left, result);
        postorderHelper(node.right, result);
        result.add(node.val);
    }

    private static List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode lastVisited = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode peekNode = stack.peek();

            if (peekNode.right != null && lastVisited != peekNode.right) {
                current = peekNode.right;
            }
            else {
                result.add(peekNode.val);
                lastVisited = stack.pop();
            }
        }

        return result;
    }
}
