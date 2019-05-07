package cn.scut;

import java.util.Arrays;

public class EvenNumberBeforeOddNumber {

    public static void reOrderArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) { //遇到有数就一直向后交换知道遇到第一个偶数或者到数组最后的位置
                for (int j = i; j < array.length - 1; j++) {
                    if (array[j + 1] % 2 == 0) {
                        break;
                    }else{
                        //交换
                        int t = array[j];
                        array[j] = array[j+1];
                        array[j+1] = t;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 5, 8, 7};

        reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
}
