package CodeForces.Div2_B;

/*
 * check : https://codeforces.com/contest/47/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = 0;
        char x, y;
        x = y = ' ';
        char[][] arr = new char[3][2];
        char[] arr2 = new char[3];
        char[] arr3 = {'A', 'B', 'C'};
        String str;
        for (int i = 0; i < 3; i++) {
            str = sc.next();
            if (str.charAt(1) == '<') {
                arr[i][1] = str.charAt(2);
                arr[i][0] = str.charAt(0);
            } else {
                arr[i][1] = str.charAt(0);
                arr[i][0] = str.charAt(2);
            }
        }
        for (int i = 0; i < 3; i++) {
            x = arr[i][1];
            for (int j = 0; j < 3; j++) {
                if (arr[j][1] == x)
                    c++;
            }
            if (c == 2) {
                arr2[2] = x;
                break;
            }
            c = 0;
        }
        if (c != 2) {
            System.out.println("Impossible");
            return;
        }
        for (int i = 0; i < 3; i++) {
            y = arr[i][0];
            for (int j = 0; j < 3; j++) {
                if (arr[j][0] == y)
                    c++;
            }
            if (c == 2) {
                arr2[0] = y;
                break;
            }
            c = 0;
        }
        for (int i = 0; true; i++) {
            if (arr3[i] != x && arr3[i] != y) {
                arr2[1] = arr3[i];
                break;
            }
        }
        for (char ch : arr2) {
            System.out.print(ch);
        }
    }
}
