package Java.Easy;

public class _104_MaxDepthOfTree {
    public static void main(String[] args) {
        System.out.println("#104 - Maximum Depth of Binary Tree - Easy");

        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maxDepth(root);
        System.out.println("Max Depth: " + depth);

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

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left) + 1;
        int rightDepth = maxDepth(root.right) + 1;

        return Math.max(leftDepth, rightDepth);
    }
}
