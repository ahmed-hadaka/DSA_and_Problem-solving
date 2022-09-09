package Div2_A;

/*
 * code:http://codeforces.com/contest/298/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Snow_Footprints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char start = ' ', end = ' ';
        int i, j;
        int n = sc.nextInt();
        String str = sc.next();
        for (i = 0; i < str.length(); i++) { // get first from beginning
            start = str.charAt(i);
            if (start != '.') break;
        }

        for (j = str.length() - 1; j >= 0; j--) { // get first from the end
            end = str.charAt(j);
            if (end != '.') break;
        }
        if (start == 'R' && end == 'R') {
            System.out.println((i + 1) + " " +( j + 2));
        } else if (start == 'L' && end == 'L') {
            System.out.println((j + 1) + " " +( i));
        } else { // start == R & end == L
            for (j = str.length() - 1; j >= 0; j--) { // get first R from the end
                end = str.charAt(j);
                if (end == 'R') break;
            }
            System.out.println((i + 1) + " " + (j + 1));
        }
    }
}
