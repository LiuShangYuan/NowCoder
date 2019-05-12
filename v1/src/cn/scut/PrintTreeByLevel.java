package cn.scut;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public class PrintTreeByLevel {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.remove();
            list.add(node.val);

            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }


        return list;
    }


    public static void main(String[] args) {

    }
}
