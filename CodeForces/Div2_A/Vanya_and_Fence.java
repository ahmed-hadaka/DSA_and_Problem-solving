package Div2_A;
/*
 * code:http://codeforces.com/contest/677/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Vanya_and_Fence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, h, x, ans = 0;
        n = sc.nextInt();
        h = sc.nextInt();

        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            if (x > h)
                ans++;
            ans++;
        }
        System.out.println(ans);

    }
}
