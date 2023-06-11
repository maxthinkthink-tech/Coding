package brain.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    public List<Integer> preorderTraversalRecur(BinaryTreeNode node) {
        List<Integer> preorder = new LinkedList<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        preOrderRecur(node, preorder);

        return preorder;
    }

    public void preOrderRecur(BinaryTreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        preOrderRecur(node.left, res);
        preOrderRecur(node.right, res);
    }

    public List<Integer> preorderTraversal(BinaryTreeNode node) {
        List<Integer> preorder = new LinkedList<>();
        if (node == null) {
            return preorder;
        }

        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            BinaryTreeNode t = stack.pop();
            preorder.add(t.val);
            if (t.right != null) {
                stack.push(t.right);
            }
            if (t.left != null) {
                stack.push(t.left);
            }
        }
        return preorder;
    }

    public List<Integer> preorderTraversalV2(BinaryTreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }

    //    inorder
    public List<Integer> inorderTraversalRecur(BinaryTreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorderTraversalRecur(root, res);
        return res;
    }

    public void inorderTraversalRecur(BinaryTreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversalRecur(root.left, res);
        res.add(root.val);
        inorderTraversalRecur(root.right, res);
    }

    public List<Integer> inorderTraversal(BinaryTreeNode node) {
        List<Integer> res = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;
    }

    public List<Integer> postOrder(BinaryTreeNode root) {
        List<Integer> res = new LinkedList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode pre = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (root.right == null) {
                res.add(root.val);
                pre = root;
                root = null;
            } else if (pre == root.right) {
                res.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }


    public int maxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int maxDepthQueue(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                BinaryTreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    public boolean isSymmetric(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(BinaryTreeNode l, BinaryTreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l == null || r == null) {
            return false;
        }
        return l.val == r.val && isMirror(l.left, r.right) && isMirror(l.right, r.left);
    }

    public boolean isMirrorIter(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            BinaryTreeNode l = queue.poll();
            BinaryTreeNode r = queue.poll();
            if (l == null && r == null) {
                continue;
            }

            if (l == null || r == null) {
                return false;
            }
            if (l.val != r.val) {
                return false;
            }
            queue.offer(l.left);
            queue.offer(r.right);
            queue.offer(l.right);
            queue.offer(r.left);
        }

        return true;
    }

    public boolean hasPathSum(BinaryTreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSumIter(BinaryTreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        Queue<Integer> values = new LinkedList<>();
        nodes.offer(root);
        values.offer(root.val);
        while (!nodes.isEmpty()) {
            BinaryTreeNode n = nodes.poll();
            Integer v = values.poll();
            if (n.left == null && n.right == null && v == targetSum) {
                return true;
            }
            if (n.left != null) {
                nodes.offer(n.left);
                values.offer(n.left.val + v);
            }
            if (n.right != null) {
                nodes.offer(n.right);
                values.offer(n.right.val + v);
            }
        }
        return false;
    }
}