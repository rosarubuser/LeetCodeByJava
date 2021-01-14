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

// dummy solution T T 
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        ArrayList<LinkedList<TreeNode>> tree = new ArrayList<>();
        tree.add(new LinkedList<>());
        tree.get(0).add(root);
        tree.add(new LinkedList<>());
        tree.get(1).add(root.left);
        tree.get(1).add(root.right);
        for (int level = 1; level < tree.size(); level++) {
            LinkedList<TreeNode> curr = tree.get(level);
            if (curr.size() % 2 != 0)
                return false;
            
            if (!curr.isEmpty()) {
                System.out.println(curr);
                tree.add(new LinkedList<>());
                LinkedList<TreeNode> nextL = tree.get(level + 1);
                
                while (!curr.isEmpty()) {
                    TreeNode head = curr.pollFirst(), tail = curr.pollLast();
                    if (head == null && tail == null) continue;
                    if (head == null || tail == null) return false;
                    if (head.val != tail.val)
                        return false;
                    nextL.addFirst(head.left);
                    nextL.addLast(tail.right);
                    nextL.addFirst(head.right);
                    nextL.addLast(tail.left);
                }
            }
        }
        return true;
    }
}