package Div2_A;

/*
 * code: https://codeforces.com/contest/731/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Night_at_the_Museum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = 97, c = 0, diff;
        String str = sc.next();
        for (int i = 0; i < str.length(); i++) {
            diff = Math.abs(str.charAt(i) - p);
            if (diff <= 13)
                c += diff;
            else
                c += (26 - diff);
            p = str.charAt(i);
        }
        System.out.println(c);
    }
}
