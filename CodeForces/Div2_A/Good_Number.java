package Div2_A;

/*
 * code: http://codeforces.com/contest/365/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Good_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input, str = "0123456789";
        boolean flag;
        int count = 0;
        int n = sc.nextInt();
        int k = sc.nextInt();
        str = str.substring(0, k + 1);
        for (int i = 0; i < n; i++) {
            input = sc.next();
            flag = true;
            for (int j = 0; j < str.length(); j++) {
                if (!input.contains(String.valueOf(str.charAt(j)))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        System.out.println(count);
    }
}
