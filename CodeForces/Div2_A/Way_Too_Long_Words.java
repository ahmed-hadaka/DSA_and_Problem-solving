package Div2_A;
/*
 * code: http://codeforces.com/contest/71/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Way_Too_Long_Words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        String[] stA;
        n = sc.nextInt();
        stA = new String[n];
        for (int i = 0; i <n ; i++) {
            stA[i] = sc.next();
        }
        for (int i = 0; i < n; i++) {
            if (stA[i].length() > 10) {
                System.out.print(stA[i].charAt(0));
                System.out.print(stA[i].length() - 2);
                System.out.print(stA[i].charAt((stA[i].length() - 1)));
                System.out.println();
            } else
                System.out.println(stA[i]);
        }

    }
}
