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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        if (root == null) return res;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode ptr = stack.pop();
            res.addFirst(ptr.val);
            if (ptr.left != null) 
                stack.push(ptr.left);
            if (ptr.right != null){
                stack.push(ptr.right);
            }
        }
        return res;
    }
}