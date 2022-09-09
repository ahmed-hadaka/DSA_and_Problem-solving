package Div2_B;

/*
 * check : http://codeforces.com/contest/492/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Arrays;
import java.util.Scanner;

public class Vanya_and_Lanterns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long l = sc.nextLong();
        long[] arr = new long[n];
        double res = -1;
        double max = 0;
        double sub;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        if (n == 1) {
            System.out.println(Math.max(arr[0], l - arr[0]));
        } else {
            Arrays.sort(arr);
            for (int i = 0; i < n - 1; i++) {
                sub = arr[i + 1] - arr[i];
                if (sub > max)
                    max = sub;
            }
            if (l - arr[arr.length - 1] > max / 2)
                res = l - arr[arr.length - 1];
            if (arr[0] > max / 2 && arr[0] > res)
                res = arr[0];
            if (res != -1)
                System.out.println(res);
            else
                System.out.println(max / 2);
        }
    }
}
