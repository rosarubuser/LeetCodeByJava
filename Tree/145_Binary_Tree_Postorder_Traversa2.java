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

// iteration

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        if (root == null) return res;
        
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode ptr = stack.peek();
            if (ptr.left == null && ptr.right == null) {
                TreeNode item = stack.pop();
                res.add(item.val);
            } else {
                if (ptr.right != null) {
                    stack.push(ptr.right);
                    ptr.right = null;
                }
                
                if (ptr.left != null) {
                    stack.push(ptr.left);
                    ptr.left = null;
                }
            }
        }
        return res;
    }
}