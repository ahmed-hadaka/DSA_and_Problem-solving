package Div2_A;

/*
 * code: http://codeforces.com/contest/143/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Help_Vasilisa_the_Wise_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x1, x2, x3, x4;
        x1 = x2 = x3 = x4 = 0;
        boolean flag = false;
        int r1 = sc.nextInt();
        int r2 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int p1 = sc.nextInt();
        int p2 = sc.nextInt();
        for (int i = 1; i <= 9; i++) {
            flag = false;
            x1 = i;
            x2 = r1 - x1;
            if (check(x1, x2)) {
                flag = true;
                continue;
            }
            x3 = c1 - x1;
            if (check(x1, x3)) {
                flag = true;
                continue;
            }
            x4 = p1 - x1;
            if (check(x1, x4)) {
                flag = true;
                continue;
            }
            if (x2 == x3 || x2 == x4 || x3 == x4) {
                flag = true;
                continue;
            }
            if (r2 != x3 + x4 || c2 != x2 + x4 || p2 != x2 + x3) {
                flag = true;
                continue;
            }
            break;
        }
        if (flag)
            System.out.println(-1);
        else
            System.out.println(x1 + " " + x2 + "\n" + x3 + " " + x4);
    }

    public static boolean check(int x1, int x2) {
        return x1 == x2 || x2 > 9 || x2 <= 0;
    }
}
