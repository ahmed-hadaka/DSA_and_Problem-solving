package Div2_B;

/*
 * code:https://codeforces.com/contest/746/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Decoding {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] arr = new char[n];
        int x, y;
        if (n == 1 || n == 2) {
            System.out.println(str);
        } else {
            if (n % 2 == 0) {
                x = y = (n / 2) - 1;
                arr[x] = str.charAt(0);
                for (int i = 1; i < n; i++) {
                    if (i % 2 != 0) // odd index
                        arr[++x] = str.charAt(i);
                    else
                        arr[--y] = str.charAt(i);
                }
            } else {
                x = y = (n / 2);
                arr[x] = str.charAt(0);
                for (int i = 1; i < n; i++) {
                    if (i % 2 != 0) // odd index
                        arr[--y] = str.charAt(i);
                    else
                        arr[++x] = str.charAt(i);
                }
            }
            for (char ch : arr) {
                System.out.print(ch);
            }
        }
    }
}