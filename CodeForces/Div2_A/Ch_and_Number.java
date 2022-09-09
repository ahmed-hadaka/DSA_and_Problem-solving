package Div2_A;
/*
 * code: http://codeforces.com/contest/514/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Ch_and_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if ((i == 0 && arr[i] == '9') || arr[i] <= '4')
                continue;
            arr[i] = (char)('9' - arr[i] + '0');
        }
        for (char c : arr) {
            System.out.print(c);
        }
    }
}
