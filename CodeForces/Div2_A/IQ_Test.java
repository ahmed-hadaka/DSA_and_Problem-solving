package Div2_A;

/*
 * code: https://codeforces.com/contest/287/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class IQ_Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] arr = new char[4][4];
        String ans = "NO";
        char x, y;
        boolean flag = false;
        String s;
        for (int i = 0; i < 4; i++) { // fill arr
            s = sc.next();
            for (int j = 0; j < 4; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    x = arr[i][j];
                    if ((arr[i + 1][j] == x) || (arr[i + 1][j + 1] == x)) {
                        ans = "YES";
                        flag = true;
                        break;
                    }
                } else {
                    x = arr[i][j];
                    y = arr[i][j + 1];
                    if ((arr[i + 1][j] == x) && (arr[i + 1][j + 1] == x)) {
                        ans = "YES";
                        flag = true;
                        break;
                    } else if ((arr[i + 1][j] == y) && (arr[i + 1][j + 1] == y)) {
                        ans = "YES";
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) break;
        }
        System.out.println(ans);
    }
}
