package Div2_A;

import java.util.Scanner;

/*
 * code: https://codeforces.com/contest/69/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */
public class Young_Physicist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0, y = 0, z = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            x += sc.nextInt();
            y += sc.nextInt();
            z += sc.nextInt();
        }
        if (x == 0 && y == 0 && z == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
