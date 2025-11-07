package Java.Medium;

public class _450_DeleteNodeBST {
    public static void main(String[] args) {
        System.out.println("#450 - Delete Node in a BST - Medium");

        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        TreeNode newRoot = deleteNode(root, 3);

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

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null && root.right == null) {
                return null;
            }

            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode successor = findMin(root.right);
            root.val = successor.val;
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}
