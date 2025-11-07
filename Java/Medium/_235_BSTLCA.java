package Java.Medium;

public class _235_BSTLCA {
    public static void main(String[] args) {
        System.out.println("#235 - Lowest Common Ancestor of a Binary Tree - Medium");

        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(8);

        root.left = left;
        root.right = right;

        TreeNode lca = lowestCommonAncestor(root, left, right);
        System.out.println("Lowest Common Ancestor: " + lca.val);

        TreeNode recursiveSolution = lcaRecursive(root, left, right);
        System.out.println("Recursive Solution: " + recursiveSolution.val);

        return;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;

        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                current = current.left;
            }
            else if (p.val > current.val && q.val > current.val) {
                current = current.right;
            }
            else {
                return current;
            }
        }

        return null;
    }

    private static TreeNode lcaRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lcaRecursive(root.left, p, q);
        }
        else if (p.val > root.val && q.val > root.val) {
            return lcaRecursive(root.right, p, q);
        }
        else {
            return root;
        }
    }
}
