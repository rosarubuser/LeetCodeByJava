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
        List<Integer> res = new ArrayList<> ();
        Stack<TreeNode> stack = new Stack<> ();
        stack.push(root);
        if (root == null) return res;
        
        while (!stack.isEmpty()) {
            TreeNode ptr = stack.pop();
            res.add(ptr.val);
            if (ptr.left != null) 
                stack.push(ptr.left);
            if (ptr.right != null){
                stack.push(ptr.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}