package Div2_A;

/*
 * code: http://codeforces.com/contest/318/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Fancy_Fence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i;
        double angle;
        String ans;
        int t = sc.nextInt();
        for (int j = 0; j < t; j++) {
        int a = sc.nextInt();
        i = 3;
        ans = "NO";
            do {
                angle = (double) (i - 2) * 180 / i;
                if (angle == a) {
                    ans = "YES";
                    break;
                }
                i++;
            } while (angle <= a);
            System.out.println(ans);
        }
    }
}
