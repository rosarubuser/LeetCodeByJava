// Method 1
class Solution {
    private int res = 100000;
    public int minDepth(TreeNode root) {
        minDepthHelper(root, 0);
        return res;
    }
    
    private void minDepthHelper(TreeNode root, int level) {
        if (root != null)
            level += 1;
        
        if (root == null || (root.left == null && root.right == null)) {
            if (level < res)
                res = level;
            return;
        }
        // System.out.println("current node is " + root.val);
        // System.out.println("current level is " + level);
        // System.out.println("current res is " + res);
        if (root.left != null)
            minDepthHelper(root.left, level);
        if (root.right != null)
            minDepthHelper(root.right, level);
    }
}

// Method 2
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}

// BFS
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        boolean found = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level += 1;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    found = true;
                    break;
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            if (found == true)
                break;
        }
        return level;
    }
}

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level += 1;
            while (size-- > 0) {
                TreeNode curr = queue.poll();
                if (curr.left == null && curr.right == null) {
                    return level;
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return level;
    }
}