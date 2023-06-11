package brain.tree;

public class BinaryTreeNode {
        int val;
        brain.tree.BinaryTreeNode left;
        brain.tree.BinaryTreeNode right;

        BinaryTreeNode() {
        }

        BinaryTreeNode(int val) {
            this.val = val;
        }

        BinaryTreeNode(int val, brain.tree.BinaryTreeNode left, brain.tree.BinaryTreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
}
