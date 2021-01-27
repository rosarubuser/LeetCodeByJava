class Solution {
    int max_dia;
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        max_dia = Integer.MIN_VALUE;
        backtrace(root);
        return max_dia;
    }
    
    private int backtrace(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = backtrace(node.left);
        int right = backtrace(node.right);
        max_dia = Math.max(max_dia, left + right);
        return Math.max(left, right) + 1;
    }
}