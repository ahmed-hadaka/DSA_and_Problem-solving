package Div2_A;
/*
 * code: http://codeforces.com/problemset/problem/767/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Snacktower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, max, num;
        boolean[] arr;
        n = sc.nextInt();
        max = n;
        arr = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            num = sc.nextInt();
            arr[num] = true;
            while (arr[max]) {
                System.out.print(max + " ");
                max--;
            }
            System.out.println();
        }
    }
}
