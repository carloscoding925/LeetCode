package Java.Medium;

import java.util.Stack;

public class _230_KthSmallestElementBST {
    public static void main(String[] args) {
        System.out.println("#230 - Kth Smallest Element in a BST - Medium");

        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        int k = 1;

        int result = kthSmallest(root, k);
        System.out.println(k + " smallest element: " + result);

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

    private static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodeStack = new Stack<>();
        TreeNode current = root;

        while (current != null || !nodeStack.isEmpty()) {
            while (current != null) {
                nodeStack.push(current);
                current = current.left;
            }

            current = nodeStack.pop();
            k--;

            if (k == 0) {
                return current.val;
            }

            current = current.right;
        }

        return -1;
    }
}
