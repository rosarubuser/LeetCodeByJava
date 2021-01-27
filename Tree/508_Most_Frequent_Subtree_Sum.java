class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>(); // key: sum, val: freq.
        findSum(root, map);
        return findFrequentSum(map);
    }
            
    private int findSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            return root.val;
        }
        
        int left = findSum(root.left, map);
        int right = findSum(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
    
    private int[] findFrequentSum(Map<Integer, Integer> map) {    // max freq.
        if (map.isEmpty()) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> list = null;
        for (Integer i : map.keySet()) {
            if (max < map.get(i)) {
                max = map.get(i);
                list = new ArrayList<>();
                list.add(i);
            } else if (max == map.get(i)) {
                list.add(i);
            }
        }
        return listToArray(list);
    }
    
    private int[] listToArray(ArrayList<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}


class Solution {
    Map<Integer, Integer> counts = new HashMap<>();
    int maxCount = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res = new ArrayList<>();
        for (int s : counts.keySet()) {
            if (counts.get(s) == maxCount) {
                res.add(s);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    
    private int dfs(TreeNode root) {
        if (root == null)
            return 0;
        int sum = dfs(root.right) + dfs(root.left) + root.val;
        counts.put(sum, counts.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, counts.get(sum));
        return sum;
    }
}