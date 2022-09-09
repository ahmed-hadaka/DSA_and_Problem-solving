package Div2_A;

/*
 * code: http://codeforces.com/contest/474/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Keyboard {
    static char[][] chA1 = new char[3][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int k = 0;
        char ch;
        char[] chA2;
        String dir;
        String s = "qwertyuiopasdfghjkl;zxcvbnm,./";
        for (int i = 0; i < chA1.length; i++) {
            for (int j = 0; j < chA1[0].length; j++) {
                chA1[i][j] = s.charAt(k++);
            }
        }
        dir = sc.next();
        str = sc.next();
        chA2 = str.toCharArray();
        for (int i = 0; i < chA2.length; i++) {
            ch = find(chA2[i], dir);
            System.out.print(ch);
        }
    }

    public static char find(char ch, String dir) {
        char found = ' ';
        boolean flag = false;
        for (int i = 0; i < chA1.length; i++) {
            for (int j = 0; j < chA1[0].length; j++) {
                if (chA1[i][j] == ch && dir.equals("R")) {
                    found = chA1[i][j - 1];
                    flag = true;
                    break;
                } else if (chA1[i][j] == ch && dir.equals("L")) {
                    found = chA1[i][j + 1];
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }
        return found;
    }
}

