class Solution {
    int maxValue;
        
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        backtrace(root);
        return maxValue;
    }
    
    private int backtrace(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(0, backtrace(node.left));
        int right = Math.max(0, backtrace(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left + node.val, right + node.val);
    }
}

