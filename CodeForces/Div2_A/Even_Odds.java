package Div2_A;
/*
 * code: http://codeforces.com/contest/318/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Even_Odds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n, k, ans;
        n = sc.nextLong();
        k = sc.nextLong();
        if (k == 1)
            ans = 1;
        else if (n % 2 == 0 || n != k) {
            ans = k + (k - 1);
            if (ans > n) {
                if (n % 2 == 0)
                    ans = ans - (n - 1);
                else
                    ans = ans - (n);
            }
        } else
            ans = k - 1;
        System.out.println(ans);
    }
}
