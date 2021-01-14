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
    public int deepestLeavesSum(TreeNode root) {
        int sum = 0;
        ArrayList<ArrayList<TreeNode>> tree = new ArrayList<>();
        tree.add(new ArrayList<>());
        tree.get(0).add(root);
        for (int level = 0; ; level++) {
            for (TreeNode node : tree.get(level)) {
                tree.add(new ArrayList<>());
                if (node.left != null)
                    tree.get(level + 1).add(node.left);
                if (node.right != null)
                    tree.get(level + 1).add(node.right);
            }
            if (tree.get(level + 1).isEmpty()) {
                for (TreeNode node : tree.get(level)) {
                    sum += node.val;
                }
                break;
            }
        }
        return sum;
    }
}