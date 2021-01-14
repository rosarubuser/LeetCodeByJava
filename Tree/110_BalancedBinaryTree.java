// Recursion Top-down method
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int depthL = depthCal(root.left), depthR = depthCal(root.right);
        return depthL - depthR <= 1 && depthR - depthL <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int depthCal(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depthCal(root.left), depthCal(root.right)) + 1;
    }
}

// down-to-top method
class Solution {
    public boolean isBalanced(TreeNode root) {
        return heightCal(root) != -1;
    }
    
    private int heightCal(TreeNode root) {
        if (root == null) return 0;
        
        int lHei = heightCal(root.left);
        if (lHei == -1) return -1;
        
        int rHei = heightCal(root.right);
        if  (rHei == -1) return -1;
        
        if (Math.abs(lHei - rHei) <= 1)
            return Math.max(lHei, rHei) + 1;
        else
            return -1;
    }
}