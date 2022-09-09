package Div2_A;
/*
 * code:http://codeforces.com/contest/427/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Police_Recruits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int recruits = 0, untreated = 0, input;
        int[] arr;

        input = sc.nextInt();
        arr = new int[input];
        for (int i = 0; i < input; i++) { // fill data
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                recruits += arr[i];
            else {
                if (recruits > 0)
                    recruits--;
                else
                    untreated++;
            }
        }
        System.out.println(untreated);
    }
}
