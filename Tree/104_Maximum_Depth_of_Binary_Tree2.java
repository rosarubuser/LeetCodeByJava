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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) { // encounter the end of this level
                depth += 1;
                if (queue.peek() == null)   // two consecutive nulls in stack, means end of tree
                    break;
                else {
                    queue.offer(null);   // mark the end of next level;
                    continue;   
                }
            }
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
            
        }
        return depth;
    }
}