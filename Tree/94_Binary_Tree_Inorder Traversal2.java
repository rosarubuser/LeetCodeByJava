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

// time complexity O(n)
// space complexity O(n)

// Method: Iteration
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        TreeNode ptr = root;
        while (ptr != null || !stack.isEmpty()) {
            while (ptr != null) {
                stack.push(ptr);
                ptr = ptr.left;
            }
            ptr = stack.pop();
            res.add(ptr.val);
            ptr = ptr.right;
        }
        return res;
    }
}