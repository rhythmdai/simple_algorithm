package leetcode;

public class S951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return checkNode(root1, root2);
    }

    public boolean checkNode(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 != null && node2 == null) {
            return false;
        } else if (node1 == null && node2 != null) {
            return false;
        } else {
            if (!equals(node1, node2)) {
                return false;
            }
            if (equals(node1.left, node2.right) && equals(node1.right, node2.left)) {
                flip(node1);
            }
            return checkNode(node1.left, node2.left) && checkNode(node1.right, node2.right);
        }
    }

    public boolean equals(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        } else if (node1 == null || node2 == null) {
            return false;
        } else {
            return node1.val == node2.val;
        }

    }

    private void flip(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(6);
        TreeNode root2 = new TreeNode(3);
        root2.right = new TreeNode(6);
        new S951().checkNode(root1, root2);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}