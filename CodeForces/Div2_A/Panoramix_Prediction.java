package Div2_A;

/*
 * code: http://codeforces.com/contest/80/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Panoramix_Prediction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag;
        int i;
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (i = n + 1; i <= m; i++) {
            flag = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) break;
        }
        if (i == m)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
