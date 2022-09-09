package CodeForces.Div2_A;

/*
 * code: https://codeforces.com/contest/682/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Alyona_and_Numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int k;
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (i % 5 == 0)
                k = 5;
            else
                k = (5 - (i % 5));
            while (k <= m) {
                count++;
                k += 5;
            }
        }
        System.out.println(count);
    }
}
