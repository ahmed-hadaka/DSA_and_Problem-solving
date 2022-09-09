package Div2_B;
/*
 * check : http://codeforces.com/contest/102/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Sum_of_Digits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = 0;
        int c = 0;
        String str = sc.next();
        while (str.length() > 1) {
            for (int i = 0; i < str.length(); i++) {
                x += Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            str = Long.toString(x);
            c++;
            x = 0;
        }
        System.out.println(c);
    }
}
