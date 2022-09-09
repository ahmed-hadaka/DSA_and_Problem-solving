package Div2_A;
/*
 * code: http://codeforces.com/contest/225/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Dice_Tower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        int f;
        boolean flag = false;
        int n = sc.nextInt();
        int x = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = 7 - arr[0];
            arr[3] = 7 - arr[1];
            f = 7 - x;
            for (int j = 0; j < 4; j++) {
                if (f == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("NO");
                break;
            }
            x = 7 - f;
        }
        if (!flag)
            System.out.println("YES");

    }
}
