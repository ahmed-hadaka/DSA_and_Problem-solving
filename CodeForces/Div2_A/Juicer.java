package Div2_A;
/*
 * code: http://codeforces.com/contest/709/problem/A
 *
 * took hint
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Juicer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, b, d, o, count = 0, waste = 0;
        n = sc.nextInt();
        b = sc.nextInt();
        d = sc.nextInt();
        for (int i = 0; i < n; i++) {
            o = sc.nextInt();
            if (o > b) continue;
            waste += o;
            if (waste > d) {
                waste = 0;
                count++;
            }
        }
        System.out.println(count);
    }
}
