package Java.Medium;

public class _98_ValidateBST {
    public static void main(String[] args) {
        System.out.println("#98 - Validate Binary Search Tree - Medium");

        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        boolean isValid = isValidBST(root);

        System.out.println("Is Valid BST: " + isValid);

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

    private static boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean dfs(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if (node.val <= min || node.val >= max) {
            return false;
        }

        return dfs(node.left, min, node.val) &&
                dfs(node.right, node.val, max);
    }
}
