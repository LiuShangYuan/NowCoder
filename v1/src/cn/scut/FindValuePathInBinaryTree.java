package cn.scut;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindValuePathInBinaryTree {


    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return paths;
        }

        // leaf node
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> p = new ArrayList<>();
                p.add(root.val);
                paths.add(p);
                return paths;
            }
        }


        int new_target = target - root.val;
        ArrayList<ArrayList<Integer>> left_paths = null;
        ArrayList<ArrayList<Integer>> right_paths = null;

        if (root.left != null) {
            left_paths = FindPath(root.left, new_target);
        }

        if (root.right != null) {
            right_paths = FindPath(root.right, new_target);
        }


        if (left_paths != null) {
            for (int i = 0; i < left_paths.size(); i++) {
                ArrayList<Integer> temppath = new ArrayList<>();
                temppath.add(root.val);
                temppath.addAll(1, left_paths.get(i));
                left_paths.set(i, temppath);
            }

            for(ArrayList<Integer> p : left_paths){
                paths.add(p);
            }
        }

        if (right_paths != null) {
            for (int i = 0; i < right_paths.size(); i++) {
                ArrayList<Integer> temppath = new ArrayList<>();
                temppath.add(root.val);
                temppath.addAll(1, right_paths.get(i));
                right_paths.set(i, temppath);
            }

            for(ArrayList<Integer> p : right_paths){
                paths.add(p);
            }
        }

        paths.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if(o1.size() >= o2.size()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });


        return paths;
    }


    public static void main(String[] args) {

    }
}
