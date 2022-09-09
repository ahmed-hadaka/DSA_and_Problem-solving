package Div2_A;
/*
 * code: http://codeforces.com/contest/231/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, petya, vasya, tonya, result = 0;

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            petya = sc.nextInt();
            vasya = sc.nextInt();
            tonya = sc.nextInt();
            if ((petya + vasya + tonya) >= 2)
                result++;
        }
        System.out.println(result);
    }
}
