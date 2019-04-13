package cn.scut;

//import sun.reflect.generics.tree.Tree;

//import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树(不含重复数字)
 *
 * 225ms(可以提速吗？)
 */



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


// 1)由前序的第一个元素确定根节点
// 2)用该元素在中序序列的位置将元素分成左子树和右子树两个部分
// 3)递归调用上面的方法构建

public class ReConstructBinaryTree {

    public static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        // List传递引用, 递归过程可以操作同一个集合
        List<Integer> pre_list = new ArrayList<>();
        for (int i = 0; i < pre.length; i++) {
            pre_list.add(pre[i]);
        }


        return reConstructBinaryTree_(pre_list, in);
    }



    public static TreeNode reConstructBinaryTree_(List<Integer> pre_list, int[] in){
        if (in.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(pre_list.get(0));

        // 找到pre[0] 在中序序列的位置
        int rootIndex = search(in, pre_list.get(0));
        pre_list.remove(0);

        int[] lin = Arrays.copyOfRange(in, 0, rootIndex);
        int[] rin = Arrays.copyOfRange(in, rootIndex + 1, in.length);


        TreeNode letf_tree = reConstructBinaryTree_(pre_list, lin);

        TreeNode right_tree = reConstructBinaryTree_(pre_list, rin);


        root.left = letf_tree;
        root.right = right_tree;

        return root;
    }

    public static void main(String[] args) {
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};

        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};


        TreeNode tree = reConstructBinaryTree(pre, in);


        System.out.println();

    }
}
