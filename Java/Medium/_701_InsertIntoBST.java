package Java.Medium;

public class _701_InsertIntoBST {
    public static void main(String[] args) {
        System.out.println("#701 - Insert into a Binary Search Tree - Medium");

        TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        TreeNode newRoot = insertIntoBST(root, 5);

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

    private static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root;

        while (true) {
            if (val < current.val) {
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    return root;
                }

                current = current.left;
            }
            else {
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    return root;
                }

                current = current.right;
            }
        }
    }
}
