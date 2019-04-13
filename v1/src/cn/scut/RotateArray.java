package cn.scut;

/**
 * 输入一个旋转数组, 输出其最小值
 */
public class RotateArray {

    public static int minNumberInRotateArray_v1(int[] array) {
        if (array.length == 0) {
            return 0;
        }


        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                return array[i + 1];
            }
        }


        return array[0];
    }



    // 二分
    public static int minNumberInRotateArray_v2(int[] array) {
        if (array.length == 0) {
            return 0;
        }


        // 前一半的数大于后一般的数
        // 1) low < mid ==> 最小值在 mid到high之间
        // 2) low == mid
        // 3) low > mid ==> 最小值在low到mid之间
        int low = 0;
        int high = array.length-1;

        while(low < high){
            int mid = (low + high) / 2;
            System.out.println("low="+low+"-- high="+high+" ---mid="+mid);
            if(array[low] < array[mid]){
                low = mid;
            }else if(array[low] > array[mid]){
                high = mid;
            }else{
                return array[mid+1];
            }
        }
        return 0;
    }






    public static void main(String[] args) {

        int[] array = {5, 4, 1, 2, 3};
//        int[] array = {1, 2, 3 ,4, 5};
        System.out.println(minNumberInRotateArray_v2(array));
    }
}
