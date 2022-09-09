package Div2_B;

/*
 * check : https://codeforces.com/contest/363/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Fence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int index = 1, min = Integer.MAX_VALUE, sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { // fill
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < (n - (k - 1)); i++) {
            for (int j = i; j < i+k; j++)
                sum += arr[j];
            if (sum < min) {
                index = i + 1;
                min = sum;
            }
                sum = 0;
        }
        System.out.println(index);
    }
}
