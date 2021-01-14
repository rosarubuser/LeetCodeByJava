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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> compair = new LinkedList<>();
        compair.add(root);
        compair.add(root);
        while (!compair.isEmpty()) {
            TreeNode e1 = compair.poll();
            TreeNode e2 = compair.poll();
            if (e1 == null && e2 == null) continue;
            if (e1 == null || e2 == null) return false;
            if (e1.val != e2.val) return false;
            compair.add(e1.left);
            compair.add(e2.right);
            compair.add(e1.right);
            compair.add(e2.left);
        }
        return true;
    }
}