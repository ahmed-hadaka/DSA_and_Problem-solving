package Div2_A;

/*
 * code: http://codeforces.com/contest/1/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Theatre_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double c1, c2;
        long ans;
        double n = sc.nextLong();
        double m = sc.nextLong();
        double a = sc.nextLong();
        c1 = Math.ceil(n / a);
        c2 = Math.ceil(m / a);
        ans = (long) (c1 * c2);
        System.out.println(ans);
                /* ------ another solution -----

       //        if (n > a) {
//            c1 = 0;
//            for (int i = 0; i < n; i += a)
//                c1++;
//        }
//        if (m > a) {
//            c2 = 0;
//            for (int i = 0; i < m; i += a) {
//                c2++;
//            }
//        }
        *--------------------------- */
    }
}
