package Div2_A;

/*
 * code: https://codeforces.com/contest/699/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Launch_of_Collider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = -1;
        long min = Long.MAX_VALUE,temp;

        int n = sc.nextInt();
        String s = sc.next();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                if (i == 0) continue;
                if (x == -1) continue;
                    else {
                    temp = (arr[i] - x) / 2;
                    if (temp < min) {
                        min = temp;
                        if (min == 1) break;
                    }
                }
            } else {
                x = arr[i];
            }
        }
        if (min == Long.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(min);
    }
}
