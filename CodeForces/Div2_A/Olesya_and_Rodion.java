package Div2_A;
/*
 * code: http://codeforces.com/contest/584/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Olesya_and_Rodion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans = "";
        int n = sc.nextInt();
        int t = sc.nextInt();
        if (n < 2 && t == 10)
            ans = "-1";
        else if (n >= 2 && t == 10) {
            for (int i = 0; i < n-1; i++) {
                ans += "1";
            }
            ans += "0";
        } else
            for (int i = 0; i < n; i++) {
                ans += Integer.toString(t);
            }

        System.out.println(ans);
    }
}
