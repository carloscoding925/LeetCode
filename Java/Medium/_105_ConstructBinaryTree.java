package Java.Medium;

import java.util.HashMap;
import java.util.Map;

public class _105_ConstructBinaryTree {
    public static void main(String[] args) {
        System.out.println("#105 - Construct Binary Tree from Preorder and Inorder Traversal");

        int[] pre = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode result = buildTree(pre, inorder);

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

    private static int preorderIndex;
    private static Map<Integer, Integer> inorderIndexMap;

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        preorderIndex = 0;
        return buildTreeHelper(preorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int inorderLeft, int inorderRight) {
        if (inorderLeft > inorderRight) {
            return null;
        }

        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inorderIndexMap.get(rootValue);

        root.left = buildTreeHelper(preorder, inorderLeft, inorderIndex - 1);
        root.right = buildTreeHelper(preorder, inorderIndex + 1, inorderRight);

        return root;
    }
}
