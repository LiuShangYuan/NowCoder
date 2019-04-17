package cn.scut;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class FrogJumpFloor {
    //1) n=1时有1种
    //2) n=2时有2种
    //3) n=3是可以从第一级台阶跳一步，也可以从第二级台阶跳两步
    //4) n=n是jf(n-2) + jf(n-1)
    public static int JumpFloor(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
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

        System.out.println(JumpFloor(1));
    }
}
