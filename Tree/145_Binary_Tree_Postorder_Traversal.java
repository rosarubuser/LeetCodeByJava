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

// Recursion
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        postorderTraversalHelper(root, res);
        return res;
    }
    
    public void postorderTraversalHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null)
                postorderTraversalHelper(root.left, res);
            if (root.right != null)
                postorderTraversalHelper(root.right, res);
            res.add(root.val);
        }
    }
}