package Div2_A;

/*
 * code: http://codeforces.com/contest/567/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Lineland_Mail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, min1, min2, finalMin, max1, max2, finalMax;
        int[] arr;
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                finalMin = Math.abs(arr[i] - arr[(i + 1)]);
            } else {
                min1 = Math.abs(arr[i] - arr[(i - 1)]);
                min2 = Math.abs(arr[i] - arr[(i + 1) % arr.length]);
                finalMin = Math.min(min1, min2);
            }
            max1 = Math.abs(arr[i] - arr[0]);
            max2 = Math.abs(arr[i] - arr[arr.length - 1]);
            finalMax = Math.max(max1, max2);
            System.out.println(finalMin + " " + finalMax);
        }


    }
}
