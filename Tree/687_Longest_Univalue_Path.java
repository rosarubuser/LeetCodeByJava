class Solution {
    int max_value;
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        max_value = Integer.MIN_VALUE;
        backtrace(root);
        return max_value;
    }
    
    private int backtrace(TreeNode node) {
        if (node == null) 
            return 0;
        int left, right;
        
        // System.out.println("current node is " + node.val);
        
        left = backtrace(node.left);
        if (node.left == null || node.left.val != node.val)
            left = 0;
            
        right = backtrace(node.right);
        if (node.right == null || node.right.val != node.val)
            right = 0;
        
        max_value = Math.max(max_value, left + right);
        return Math.max(left, right) + 1;
    }
}

