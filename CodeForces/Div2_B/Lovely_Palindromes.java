package Div2_B;

/*
 * check : http://codeforces.com/contest/688/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Lovely_Palindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.next();
        StringBuilder ans = new StringBuilder(str);
        for (int i = str.length() - 1; i >= 0; i--) {
            ans.append(str.charAt(i));
        }
        System.out.println(ans);

    }
}
