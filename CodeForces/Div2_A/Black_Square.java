package Div2_A;
/*
 * code: http://codeforces.com/contest/431/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Black_Square {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = 0, calories = 0;
        int[] arr = new int[4];
        String str;
        char[] chA;
        while (i < 4) {
            arr[i] = sc.nextInt();
            i++;
        }
        str = sc.next();
        chA = str.toCharArray();
        for (int j = 0; j < chA.length; j++) {
            switch (chA[j]) {
                case '1':
                    calories += arr[0];
                    break;
                case '2':
                    calories += arr[1];
                    break;
                case '3':
                    calories += arr[2];
                    break;
                case '4':
                    calories += arr[3];
                    break;
            }
        }
        System.out.println(calories);
    }
}
