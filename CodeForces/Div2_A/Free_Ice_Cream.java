package Div2_A;

/*
 * code: http://codeforces.com/contest/686/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Free_Ice_Cream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n , d = 0, digit;
        long x;
        String[] input;
        n = sc.nextInt();
        x = sc.nextInt();
        input = new String[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextLine();
        }
        for (int i = 0; i < n; i++) {
            digit = Integer.parseInt(input[i].substring(2));
            if (input[i].charAt(0) == '+')
                x += digit;
            else if (digit <= x)
                x -= digit;
            else
                d++;
        }
        System.out.println(x + " " + d);

    }
}
