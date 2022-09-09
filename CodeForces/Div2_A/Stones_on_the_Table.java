package Div2_A;
/*
 * code:http://codeforces.com/contest/266/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Stones_on_the_Table {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input, deleted = 0;
        String str;
        char[] chA;
        input = sc.nextInt();
        str = sc.next();

        if (str.length() == input) {
            chA = str.toCharArray();
            for (int i = 0; i < chA.length - 1; i++) {
                if (chA[i] == chA[i + 1])
                    deleted++;
            }
            System.out.println(deleted);
        }
    }
}
