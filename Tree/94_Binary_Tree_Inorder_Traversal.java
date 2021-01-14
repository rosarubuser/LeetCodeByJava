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

// Time Complexity O(n)
// Space Complexity worst case O(n)

// Method: Recursion
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        inorderTraversalHelper(root, res);
        return res;
    }
    
    private void inorderTraversalHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null)
                inorderTraversalHelper(root.left, res);
        res.add(root.val);
            if (root.right != null)
                inorderTraversalHelper(root.right, res);
        }
    }
}