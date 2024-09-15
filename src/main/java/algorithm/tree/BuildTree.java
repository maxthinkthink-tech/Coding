package algorithm.tree;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BuildTree {
    private static Map<Integer, Integer> indexMap;

    public static void main(String[] args) {
        int[] p = {3,9,20,15,7};
        int[] i = {9,3,15,20,7};
        buildTree(p, i);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return tree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    private  static TreeNode tree(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {
        if (pLeft > pRight) {
            return null;
        }
        int pRoot = pLeft;
        System.out.printf("%s,%s \n", pRoot, preorder[pRoot]);
        int iRoot = indexMap.get(preorder[pRoot]);

        TreeNode root = new TreeNode(preorder[pRoot]);
        int sizeLeftSubTree = iRoot - iLeft;
        int sizeRightSubTree = iRight - iRoot;
        root.left = tree(preorder, inorder, pLeft + 1, pLeft + sizeLeftSubTree, iLeft, iRoot - 1);
        root.right = tree(preorder, inorder, pLeft + sizeLeftSubTree + 1, pRight, iRight + 1, iRight);
        return root;
    }
}
