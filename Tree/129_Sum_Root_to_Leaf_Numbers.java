class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    
    private int sumNumbersHelper(TreeNode root, int currentNum) {
        if (root == null) return 0;
        
        currentNum = currentNum * 10 + root.val;
        if (root.left == null && root.right == null)
            return currentNum;
        return sumNumbersHelper(root.left, currentNum) + sumNumbersHelper(root.right, currentNum);
    }
}