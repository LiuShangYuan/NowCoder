package cn.scut;

import java.util.Arrays;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class PostOrderOfBindarySearchTree {

    // 根节点在最后面, 把前后拆成两个序列分别判断
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        int root = sequence[sequence.length-1];
        int index = sequence.length - 1;
        // 找到左右子树的划分位置, 要考虑只有左子树和只有右子树的情况

        int i = 0;
        while (root > sequence[i]){
            i++;
        }
        index = i; // root位置

        // root 右边的应该全部大于 root
        for(int j=index; j<sequence.length;j++){
            if(root > sequence[j]){
                return false;
            }
        }

        // 满足左边小于root 右边大于root, 继续判断子序列

        boolean left = true;
        if(index > 0) {
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, index));
        }
        boolean right = true;
        if(index < sequence.length - 1) {
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, index, sequence.length - 1));
        }


        return left && right;
    }


    public static void main(String[] args) {
        int[] sequence = {5, 4, 3, 2, 1};

        System.out.println(VerifySquenceOfBST(sequence));
    }
}
