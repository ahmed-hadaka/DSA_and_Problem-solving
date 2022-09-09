package Div2_A;
/*
 * code: http://codeforces.com/contest/443/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Anton_and_Letters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st;
        int distinctLetters = 0;
        st = sc.nextLine();
        char[] chA = st.toCharArray();
        if (chA.length == 3) {
            System.out.println(1);
            return;
        }
        if (chA.length == 0) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= chA.length - 5; i += 3) {
            for (int j = i + 3; j < chA.length - 1; j += 3) {
                if (chA[i] == ' ')
                    break;
                if (chA[j] != ' ' && chA[j] == chA[i]) {
                    chA[j] = ' ';
                }
            }
        }
        for (int i = 1; i < chA.length - 1; i += 3) {
            if (chA[i] != ' ') distinctLetters++;
        }
        System.out.println(distinctLetters);
    }
}
