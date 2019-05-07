package cn.scut;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintMatrixOuter2Inner {

    public static ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();

        int rows = matrix.length;
        int columns = matrix[0].length;


        int left = 0;
        int right = columns - 1;
        int top = 0;
        int down = rows - 1;

        while (left < right && top < down) {
            // 上
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            // 右
            for (int i = top + 1; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            // 下
            for (int i = right - 1; i >= left; i--) {
                list.add(matrix[down][i]);
            }

            // 左
            for (int i = down - 1; i > top; i--) {
                list.add(matrix[i][left]);
            }

            left++;
            right--;
            top++;
            down--;
        }

        //不够完整的一圈
        if (left < right && top==down) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
        }

        if (top < down && left==right) {
            for (int i = top; i <= down; i++) {
                list.add(matrix[i][left]);
            }
        }

        if (top == down && left == right && left == top) {
            list.add(matrix[left][top]);
        }

        return list;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1, 2},{3, 4}, {5, 6}, {7, 8}, {9, 10}};

        ArrayList<Integer> list = printMatrix(matrix);

        System.out.println(list);

    }
}
