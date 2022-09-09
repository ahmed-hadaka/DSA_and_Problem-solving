package Div2_A;
/*
 * code: http://codeforces.com/contest/136/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, value;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 1; i <= n; i++) {
            value = sc.nextInt();
            arr[value - 1] = i;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }
}
