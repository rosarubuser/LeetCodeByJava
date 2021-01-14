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
// Space Complexity O(n)

// Method: Morris Traversal
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        TreeNode pre;
        List<Integer> res = new ArrayList<> ();
        while (curr != null) {
            if (curr.left != null) {
                pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = curr;
                pre = curr.left;  // reset pre
                curr.left = null;     // eliminate ptr of curr to avoid replication
                curr = pre;       // move to the next left
            } else {
                res.add(curr.val);
                curr = curr.right;
            }
        }
        return res;
    }
}