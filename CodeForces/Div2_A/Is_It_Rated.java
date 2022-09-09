package Div2_A;

/*
 * code: http://codeforces.com/contest/807/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Is_It_Rated {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        boolean flag = false;
        n = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int row = 0; row < n; row++) { // fill arr
            arr[row][0] = sc.nextInt();
            arr[row][1] = sc.nextInt();
        }
        for (int row = 0; row < n; row++) {
            if (arr[row][0] != arr[row][1]) {
                System.out.println("rated");
                flag = true;
                break;
            }
        }
        if (!flag) {
            for (int row = 0; row < n; row++) {
                if (row != n - 1 && arr[row][0] < arr[row + 1][0]) {
                    System.out.println("unrated");
                    flag = true;
                    break;
                }
            }
        }
        if (!flag)
            System.out.println("maybe");
    }
}
