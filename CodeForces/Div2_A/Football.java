package Div2_A;
/*
 * code: http://codeforces.com/contest/43/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Football {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String team1, team2 = "", input;
        int score1 = 0, score2 = 0;
        int n = sc.nextInt();
        team1 = sc.next();
        score1++;
        for (int i = 0; i < n - 1; i++) {
            input = sc.next();
            if (input.equals(team1))
                score1++;
            else {
                score2++;
                team2 = input;
            }
        }
        if (score1 > score2)
            System.out.println(team1);
        else
            System.out.println(team2);

    }
}
