package Div2_A;

/*
 * code: http://codeforces.com/contest/807/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Mountain_Scenery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[2 * n + 2];
        for (int i = 1; i < arr.length; i++) { // fill arr
            arr[i] = sc.nextInt();
        }
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 0 && k > 0 && (arr[i - 1] < arr[i] - 1) && (arr[i + 1] < arr[i] - 1)) {
                arr[i]--;
                k--;
            }
            System.out.println(arr[i]);
        }

    }
}