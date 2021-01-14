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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        preorderTraversalHelper(root, res);
        return res;
    }
    
    public void preorderTraversalHelper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.left != null)
                preorderTraversalHelper(root.left, res);
            if (root.right != null)
                preorderTraversalHelper(root.right, res);
        }
        
    }
}