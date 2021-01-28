class Solution {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }
    
    // 0: it's a leave. require a camera
    // 1: it is covered with a camera
    // 2: it is covered without a camera
    
    private int dfs(TreeNode root) {
        if (root == null) return 2;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == 0 || right == 0) {
            res ++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}

