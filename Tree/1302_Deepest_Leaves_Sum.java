/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private static int MAXLEVEL;
    
    private static int DEEPESTSUM;
    
    public int deepestLeavesSum(TreeNode root) {
        DEEPESTSUM = 0;
        MAXLEVEL = 0;
        deepestLeavesSumHelper(0, root);
        return DEEPESTSUM;
    }
    
    private void deepestLeavesSumHelper(int level, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (level == MAXLEVEL)
                DEEPESTSUM += root.val;
            if (level > MAXLEVEL) {
                MAXLEVEL = level;
                DEEPESTSUM = root.val;
            }
        }
        deepestLeavesSumHelper(level + 1, root.left);
        deepestLeavesSumHelper(level + 1, root.right);
    }
}