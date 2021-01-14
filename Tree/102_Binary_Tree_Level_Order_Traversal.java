// 1m
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) return res;
        
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res.add(new ArrayList<>());
            while (size-- > 0) {
                TreeNode element = queue.poll();
                res.get(i).add(element.val);
                if (element.left != null)
                    queue.offer(element.left);
                if (element.right != null)
                    queue.offer(element.right);
            }
            i += 1;
        }
        return res;
    }
}

// 2m
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        if (root == null) return res;
        
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size-- > 0) {
                TreeNode element = queue.poll();
                level.add(element.val);
                if (element.left != null)
                    queue.offer(element.left);
                if (element.right != null)
                    queue.offer(element.right);
            }
            res.add(level);
        }
        return res;
    }
}

// BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(root, res, 0);
        return res;
    }
    
    private void levelOrderHelper(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null)
            return;
        if (res.size() == level)
            res.add(new ArrayList<>());
        res.get(level).add(root.val);
        if (root.left != null)
            levelOrderHelper(root.left, res, level + 1);
        if (root.right != null)
            levelOrderHelper(root.right, res, level + 1);
    }
}
