package Div2_A;

/*
 * code: https://codeforces.com/contest/158/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Next_Round {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int elem : arr) {
            if (elem == 0 || elem < arr[k-1])
                break;
            else
                c++;
        }
        System.out.println(c);

    }
}
