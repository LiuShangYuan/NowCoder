package cn.scut;

import java.util.HashMap;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] array) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int num = hashMap.getOrDefault(array[i], 0) + 1;
            hashMap.put(array[i], num);
            if(num > Math.ceil(array.length / 2)){
                return array[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(6/2.0));
    }

}
