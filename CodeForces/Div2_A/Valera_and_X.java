package Div2_A;

/*
 * code: http://codeforces.com/contest/404/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Valera_and_X {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char first, second;
        String str, ans = "YES";
        boolean flag = false;
        int n = sc.nextInt();
        char[][] arr = new char[n][n];
        for (int j = 0; j < n; j++) {
            str = sc.next();
            for (int i = 0; i < n; i++) {
                arr[j][i] = str.charAt(i);
                first = arr[0][0];
                second = arr[0][1];
                if (i == j || i == n - 1 - j) {
                    if (arr[j][i] != first) {
                        flag = true;
                        ans = "NO";
                        break;
                    }
                } else if (arr[j][i] != second || arr[j][i] == first) {
                    flag = true;
                    ans = "NO";
                    break;
                }
            }
            if (flag) break;
        }
        System.out.println(ans);
    }
}
