package Div2_A;
/*
 * code: http://codeforces.com/contest/112/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Petya_and_Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st1, st2;
        int result = 0;
        char chArray1[], chArray2[];

        st1 = sc.next().toLowerCase();
        st2 = sc.next().toLowerCase();
        chArray1 = st1.toCharArray();
        chArray2 = st2.toCharArray();

        for (int i = 0; i < chArray1.length; i++) {
            if (chArray1[i] < chArray2[i]) {
                result = -1;
                break;
            } else if (chArray2[i] < chArray1[i]) {
                result = 1;
                break;
            }
        }
        System.out.println(result);
    }
}
