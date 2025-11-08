package Java.Medium;

public class _1448_GoodNodes {
    public static void main(String[] args) {
        System.out.println("#1448 - Count Good Nodes in Binary Tree - Medium");

        TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null), new TreeNode(4, new TreeNode(1), new TreeNode(5)));
        int nodes = goodNodes(root);

        System.out.println("Good Nodes Found: " + nodes);

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

    private static int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private static int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int count = node.val >= max ? 1 : 0;

        int newMax = Math.max(max, node.val);

        count = count + dfs(node.left, newMax);
        count = count + dfs(node.right, newMax);

        return count;
    }
}
