package JavaLeetcodeSolutions;

public class Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public class Main {

        public boolean isSameTree(TreeNode p, TreeNode q) {

            // Both trees are empty
            if (p == null && q == null) {
                return true;
            }

            // One tree is empty
            if (p == null || q == null) {
                return false;
            }

            // Check values and left and right subtrees
            return (p.val == q.val)
                    && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }

        public static void main(String[] args) {

            Main obj = new Main();

            // First tree
            TreeNode p = new TreeNode(1);
            p.left = new TreeNode(2);
            p.right = new TreeNode(3);

            // Second tree
            TreeNode q = new TreeNode(1);
            q.left = new TreeNode(2);
            q.right = new TreeNode(3);

            System.out.println(obj.isSameTree(p, q));
        }
    }
}
