package Div2_A;
/*
 * code: http://codeforces.com/contest/799/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Carrot_Cakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, t, k, d, currentTime = 0;
        n = sc.nextInt();
        t = sc.nextInt();
        k = sc.nextInt();
        d = sc.nextInt();
        while (currentTime <= d) { // we will find the remaining cakes after second oven become ready
            n -= k;
            currentTime += t;
        }
        if (n > 0) System.out.println("YES");
        else System.out.println("NO");
    }
}
