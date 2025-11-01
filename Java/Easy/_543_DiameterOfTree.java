package Java.Easy;

public class _543_DiameterOfTree {
    public static void main(String[] args) {
        System.out.println("#543 - Diameter of Binary Tree - Easy");

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int treeDiameter = diameterOfBinaryTree(root);

        System.out.println("Diameter of Tree: " + treeDiameter);

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

    private static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];
    }

    private static int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }

        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);

        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
