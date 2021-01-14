class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSumHelper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    private int pathSumHelper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return (sum == root.val ? 1 : 0) + pathSumHelper(root.left, sum - root.val) + pathSumHelper(root.right, sum - root.val);
    }
}

class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSumHelper(root, 0, sum, map);
    }
    
    private int pathSumHelper(TreeNode node, int sum, int target, Map<Integer, Integer> map) {
        if (node == null)
            return 0;
        sum += node.val;
        int resToCurrNode = map.getOrDefault(sum - target, 0);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        int res = resToCurrNode + pathSumHelper(node.left, sum, target, map) + pathSumHelper(node.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);
        return res;
    }
} 