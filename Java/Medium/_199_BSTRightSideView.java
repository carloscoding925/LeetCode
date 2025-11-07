package Java.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _199_BSTRightSideView {
    public static void main(String[] args) {
        System.out.println("#199 - Binary Tree Right Side View - Medium");

        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(5), null), null), new TreeNode(3));
        List<Integer> result = rightSideView(root);

        System.out.println("Right Side View of Tree: " + result.toString());

        List<Integer> recursiveResult = dfsRsv(root);
        System.out.println("Recursive Solution: " + recursiveResult.toString());

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

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode rightmost = null;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                rightmost = node;

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(rightmost.val);
        }

        return result;
    }

    private static List<Integer> dfsRsv(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private static void dfs(TreeNode node, int depth, List<Integer> result) {
        if (node == null) {
            return;
        }

        if (depth == result.size()) {
            result.add(node.val);
        }

        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
}
