class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        binaryTreePathsHelper(root, current, res);
        return res;
    }
    
    private void binaryTreePathsHelper(TreeNode root, StringBuilder current, List<String> res) {
        if (root == null)
            return;
        
        if (root.left == null && root.right == null) {
            current.append(root.val);
            System.out.println(current.toString());
            res.add(current.toString());
        } else {
            current.append(root.val + "->");
            System.out.println(current.toString());
            binaryTreePathsHelper(root.left, current, res);
            binaryTreePathsHelper(root.right, current, res);
        }
        
        int length = String.valueOf(root.val).length();
        // System.out.println(length);
        if (root.left == null && root.right == null)
            current.delete(current.length() - length, current.length());
        else
            current.delete(current.length() - length - 2, current.length());
        System.out.println(current.toString());
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root != null) binaryTreePathsHelper(root, "", res);
        return res;
    }
    
    private void binaryTreePathsHelper(TreeNode root, String current, List<String> res)     {
        if (root.left == null && root.right == null) res.add(current + root.val);
        if (root.left != null) binaryTreePathsHelper(root.left, current + root.val + "->", res);
        if (root.right != null) binaryTreePathsHelper(root.right, current + root.val + "->", res);
    }
}


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        
        if (root == null)
            return paths;
        
        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }
        
        for (String path : binaryTreePaths(root.left)) {
            paths.add(root.val + "->" + path);
        }
        
        for (String path : binaryTreePaths(root.right)) {
            paths.add(root.val + "->" + path);
        }
        
        return paths;
    }
}


class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        binaryTreePathsHelper(root, current, res);
        return res;
    }
    
    private void binaryTreePathsHelper(TreeNode root, StringBuilder current, List<String> res) {
        if (root == null)
            return;
        
        int length = current.length();
        current.append(root.val + "->");
        
        if (root.left == null && root.right == null) {
            current.setLength(current.length() - 2);  // remove the last two "->"
            res.add(current.toString());
        } 
        
        if (root.left != null)
            binaryTreePathsHelper(root.left, current, res);
        if (root.right != null)
            binaryTreePathsHelper(root.right, current, res); 
        
        current.setLength(length);
    }
}