package cn.scut;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class FrogJumpFloorII {
    public static int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }

        int[] ways = new int[target+1];
        ways[0] = 1; //从开始位置直接跳n步上去
        ways[1] = 1;
        ways[2] = 2;

        int sumways = 4;

        for (int i = 3; i <= target; i++) {
            ways[i] = sumways;
            sumways += ways[i];
        }

        return ways[target];
    }


    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }
}
