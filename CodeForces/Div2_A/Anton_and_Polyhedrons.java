package Div2_A;

/*
 * code: https://codeforces.com/contest/785/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Anton_and_Polyhedrons {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char input;
        long count = 0;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            input = sc.next().charAt(0);
            if (input == 'T')
                count += 4;
            else if (input == 'C')
                count += 6;
            else if (input == 'O')
                count += 8;
            else if (input == 'D')
                count += 12;
            else
                count += 20;
        }
        System.out.println(count);
    }
}
