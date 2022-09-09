package Div2_B;

/*
 * code:https://codeforces.com/contest/680/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Bear_and_Finding_Criminals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 0;
        int n = sc.nextInt();
        int a = sc.nextInt();
        int[] arr = new int[n];
        int[] temp1 = new int[a - 1];
        int[] temp2 = new int[n - a];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if (arr[a - 1] == 1) {
            c++;
        }
        if (a == 1) {
            System.arraycopy(arr, a, temp2, 0, temp2.length);
            for (int item : temp2) {
                if (item == 1)
                    c++;
            }
        } else if (a == n) {
            System.arraycopy(arr, 0, temp1, 0, temp1.length);
            for (int item : temp1) {
                if (item == 1)
                    c++;
            }
        } else {
            System.arraycopy(arr, 0, temp1, 0, temp1.length);
            System.arraycopy(arr, a, temp2, 0, temp2.length);
            int k = 0, i = temp1.length - 1;
            while (k < temp2.length && i >= 0) {
                if (temp1[i--] == 1 & temp2[k++] == 1)
                    c += 2;
            }
            while (i >= 0) {
                if (temp1[i--] == 1)
                    c++;
            }
            while (k < temp2.length) {
                if (temp2[k++] == 1)
                    c++;
            }
        }
        System.out.println(c);
    }
}
