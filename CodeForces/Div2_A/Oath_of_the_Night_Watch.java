package Div2_A;

/*
 * code: http://codeforces.com/contest/768/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Arrays;
import java.util.Scanner;

public class Oath_of_the_Night_Watch {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;
        int n, count = 0;
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 1; i < n - 1; i++) {
            if (arr[0] < arr[i] && arr[n - 1] > arr[i])
                count++;
        }
        System.out.println(count);
    }
}
