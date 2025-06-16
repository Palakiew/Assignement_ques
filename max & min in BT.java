class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class Solution {

    public int findMax(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int max = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            max = Math.max(max, curr.val);
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }

        return max;
    }

    public int findMin(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            min = Math.min(min, curr.val);
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }

        return min;
    }
}
