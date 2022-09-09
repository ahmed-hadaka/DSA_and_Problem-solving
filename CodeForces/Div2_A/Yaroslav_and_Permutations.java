package Div2_A;
/*
 * code: http://codeforces.com/contest/296/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Arrays;
import java.util.Scanner;

public class Yaroslav_and_Permutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, c;
        boolean flag = false;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { // fill arr
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            c = 0;
            if (arr[i] == x) continue;
            for (int k = i; k < n; k++) {
                x = arr[i];
                if (arr[i] == arr[k])
                    c++;
            }
            if ((n - c) < (c - 1)) {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println("NO");
        else
            System.out.println("YES");
    }
}
