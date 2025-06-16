class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeDiameter {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    
    public static void main(String[] args) {
       
        TreeNode root = new TreeNode(11);
        root.left = new TreeNode(21);
        root.right = new TreeNode(23);
        root.left.left = new TreeNode(34);
        root.left.right = new TreeNode(55);

        BinaryTreeDiameter tree = new BinaryTreeDiameter();
        System.out.println("Diameter of Binary Tree: " + tree.diameterOfBinaryTree(root));
    }
}
