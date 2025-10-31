package Java.Easy;

public class _226_InvertBinaryTree {
    public static void main(String[] args) {
        System.out.println("#226 - Invert Binary Tree - Easy");

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        invertTree(root);

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

    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }
}
