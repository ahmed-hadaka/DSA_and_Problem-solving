package HackerRank.DataStructures.Arrays;

/*
 * code:https://www.hackerrank.com/challenges/2d-array
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class _2D_Array_DS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[6][6];
        int max = -63, sum = 0, j = 1, l = 1;
        for (int i = 0; i < 6; i++) { // fill
            for (int k = 0; k < 6; k++) {
                arr[i][k] = sc.nextInt();
            }
        }
        for (int i = 0; i < 4; i++) {
            j++;
            for (int k = 0; k < 4; k++) {
                l++;
                sum += (arr[i][k] + arr[i][k + 1] + arr[i][k + 2] + arr[i + 1][k + 1] + arr[j][k] + arr[j][k + 1] + arr[j][k + 2]);
                if (sum > max)
                    max = sum;
                sum = 0;
            }
        }
        System.out.println(max);
    }
}
