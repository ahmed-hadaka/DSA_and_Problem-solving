package Div2_A;

/*
 * code: http://codeforces.com/contest/766/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Mahmoud_and_Longest_Uncommon_Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        if (str1.equals(str2)) {
            System.out.println(-1);
        } else
            System.out.println(Math.max(str1.length(), str2.length()));
    }
}
