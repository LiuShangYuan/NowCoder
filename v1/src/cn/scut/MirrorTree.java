package cn.scut;

/*
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/

public class MirrorTree {

    public static void Mirror(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        Mirror(root.left);
        Mirror(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode l1 = new TreeNode(6);
        TreeNode r1 = new TreeNode(10);
        TreeNode ll = new TreeNode(5);
        TreeNode lr = new TreeNode(7);
        TreeNode rl = new TreeNode(9);
        TreeNode rr = new TreeNode(11);

        root.left = l1;
        root.right = r1;
        l1.left = ll;
        l1.right = lr;
        r1.left = rl;
        r1.right = rr;

        Mirror(root);

        System.out.println("hello");
    }
}
