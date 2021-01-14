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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) // both are null
            return true;
        if (p == null || q == null) // one of p, q is null
            return false;
        if (p.val != q.val) 
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}