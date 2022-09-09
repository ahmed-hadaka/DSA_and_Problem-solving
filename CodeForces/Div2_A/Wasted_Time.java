package Div2_A;
/*
 * code: https://codeforces.com/contest/127/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Wasted_Time {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y;
        int[][] arr;
        double res = 0.0;
        int n = sc.nextInt();
        int k = sc.nextInt();
        arr = new int[n][2];
        for (int i = 0; i < n; i++) { // fill arr
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        for (int i = 1; i < n; i++) {
            x = arr[i][0] - arr[i - 1][0];
            y = arr[i][1] - arr[i - 1][1];
            res += Math.sqrt(x * x + y * y);
        }
        res = (res / 50) * k;
        System.out.format("%.9f", res);
    }
}
