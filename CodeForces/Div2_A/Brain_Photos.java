package Div2_A;

/*
 * code: http://codeforces.com/contest/707/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Brain_Photos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char color;
        String ans = "#Black&White";
        int r = sc.nextInt();
        int c = sc.nextInt();
        for (int i = 0; i < r * c; i++) {
            color = sc.next().charAt(0); // note
            if (color == 'M' || color == 'Y' || color == 'C') {
                ans = "#Color";
                break;
            }
        }
        System.out.println(ans);
    }
}
