package Div2_A;
/*
 * code: http://codeforces.com/contest/791/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Bear_And_Big_Brother {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, years = 0;
        a = sc.nextInt();
        b = sc.nextInt();
        if (a == b)
            System.out.println(1);
        else {
            while (a < b || a == b) {
                a *= 3;
                b *= 2;
                years++;
            }
            System.out.println(years);
        }

    }
}
