package Div2_A;

/*
 * code: https://codeforces.com/contest/486/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Calculating_Function {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long ans = 0;
        long n = sc.nextLong();
        // -----another solution-------------
        //        for (int i = 1; i <= n; i++) {
//            if (i % 2 == 0)
//                ans += i;
//            else
//                ans -= i;
//        }
        // ------------------
        if (n % 2 == 0)
            ans = n / 2;
        else
            ans = -(n / 2 + 1);
        System.out.println(ans);
    }
}
