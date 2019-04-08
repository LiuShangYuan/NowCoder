package cn.scut;

/**
 * 在有序的二位数组里面查找某个数
 */
public class SearchInTwoDimensionalArray {


    /**
     * 从右上角的元素考虑
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {

        if (array[0].length == 0) {
            return false;
        }

        int x = array[0].length - 1;
        int y = 0;


        while (x>=0 && y<array.length) {
            if (target == array[y][x]) {
                return true;
            } else if (target > array[y][x]) {
                y++;
            } else {
                x--;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[][] array = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}, {4, 5, 6}};
//        int[][] array = {{1, 3 ,5, 7 ,9, 11}};
        System.out.println(Find(4, array));
    }
}
