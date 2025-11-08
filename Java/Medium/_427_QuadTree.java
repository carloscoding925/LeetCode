package Java.Medium;

public class _427_QuadTree {
    public static void main(String[] args) {
        System.out.println("#427 - Construct Quad Tree - Medium");

        int[][] input = {{0, 1}, {1, 0}};
        Node tree = construct(input);

        return;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    private static Node construct(int[][] grid) {
        return constructHelper(grid, 0, 0, grid.length);
    }

    private static Node constructHelper(int[][] grid, int row, int col, int size) {
        if (isUniform(grid, row, col, size)) {
            return new Node(grid[row][col] == 1, true);
        }

        int halfSize = size / 2;

        Node topLeft = constructHelper(grid, row, col, halfSize);
        Node topRight = constructHelper(grid, row, col + halfSize, halfSize);
        Node bottomLeft = constructHelper(grid, row + halfSize, col, halfSize);
        Node bottomRight = constructHelper(grid, row + halfSize, col + halfSize, halfSize);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
    }

    private static boolean isUniform(int[][] grid, int row, int col, int size) {
        int firstVal = grid[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != firstVal) {
                    return false;
                }
            }
        }

        return true;
    }
}
