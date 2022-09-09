package Div2_A;

/*
 * code: https://codeforces.com/contest/282/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Bit_plus_plus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        char ch;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            ch = sc.next().charAt(1);
            if (ch == '-')
                x--;
            else
                x++;
        }
        System.out.println(x);
    }
}
