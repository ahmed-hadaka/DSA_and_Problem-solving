package Div2_B;

/*
 * check : https://codeforces.com/contest/227/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Effective_Approach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long start = 0, end = 0;
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            arr[in] = i + 1;
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int in = sc.nextInt();
            start += arr[in];
            end += n - arr[in] + 1;
        }
        System.out.println(start + " " + end);
    }
}
