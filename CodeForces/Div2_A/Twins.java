package Div2_A;

/*
 * code: http://codeforces.com/contest/160/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Arrays;
import java.util.Scanner;

public class Twins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, sum1 = 0, sum2 = 0, item, count = 0, target;
        int[] arr;
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            item = sc.nextInt();
            sum1 += item;
            arr[i] = item;
        }
        Arrays.sort(arr);
        target = (sum1 / 2) + 1;
        for (int i = n - 1; i >= 0 ; i--) {
            count++;
            sum2 += arr[i];
            if (sum2 >= target)
                break;
        }
        System.out.println(count);
    }
}
