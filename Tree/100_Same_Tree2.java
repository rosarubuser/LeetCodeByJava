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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        queueA.offer(p);
        queueB.offer(q);
        while (!(queueA.isEmpty() && queueB.isEmpty())) {
            TreeNode eleA = queueA.poll(), eleB = queueB.poll();
            if (eleA == null ^ eleB == null)   // one of them is null
                return false;
            
            if (eleA == null && eleB == null) continue;
            // or check both are null with && and then check one of them null with ||
            
            if (eleA.val != eleB.val) return false;
            else {
                queueA.offer(eleA.left);
                queueA.offer(eleA.right);
                queueB.offer(eleB.left);
                queueB.offer(eleB.right);
            }
        }
        return true;
    }
}