package cn.scut;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectCoverQuestion {

    //1) n=1时, 一种解法
    //2) n=2时, 两种解法
    //3) n=3时, 在n=1的基础上横放2个, 或者在n=2的基础上竖着放一个
    //
    public static int RectCover(int target) {
        if(target==0){
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }


        int[] ways = new int[target];

        ways[0] = 1;
        ways[1] = 2;

        for (int i = 2; i < target; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[target - 1];
    }


    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }
}
