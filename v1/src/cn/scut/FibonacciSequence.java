package cn.scut;

public class FibonacciSequence {
    public static int Fibonacci(int n) {

        int[] fvalue = new int[40];
        fvalue[0] = 0;
        fvalue[1] = 1;

        for (int i = 2; i <= n; i++) {
            fvalue[i] = fvalue[i-1] + fvalue[i-2];
        }

        return fvalue[n];
    }


    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        System.out.println(Fibonacci(39));

        long end = System.currentTimeMillis();

        System.out.println("time :" + (end - start));
    }

}
