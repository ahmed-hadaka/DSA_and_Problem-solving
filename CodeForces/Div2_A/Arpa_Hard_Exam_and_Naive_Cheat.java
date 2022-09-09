package Div2_A;

/*
 * code: https://codeforces.com/contest/742/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Arpa_Hard_Exam_and_Naive_Cheat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans;
        if (n == 0)
            ans = 1;
        else if (n % 4 == 1)
            ans = 8;
        else if (n % 4 == 2)
            ans = 4;
        else if (n % 4 == 3)
            ans = 2;
        else
            ans = 6;
        System.out.println(ans);
    }
}
