class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeHelper(root, root.val);
    }
    
    private boolean isUnivalTreeHelper(TreeNode root, int val) {
        if (root == null)
            return true;
        return root.val == val && isUnivalTreeHelper(root.left, val) && isUnivalTreeHelper(root.right, val);
    }
}

// one line
class Solution {
    public boolean isUnivalTree(TreeNode root) {
        return (root.left == null || root.val == root.left.val && isUnivalTree(root.left))
            && (root.right == null || root.val == root.right.val && isUnivalTree(root.right));
    }
}