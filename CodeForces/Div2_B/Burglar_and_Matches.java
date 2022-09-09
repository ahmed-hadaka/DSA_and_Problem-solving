package Div2_B;

/*
 * num : https://codeforces.com/contest/16/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Burglar_and_Matches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R, c = 0, max = 0, index = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        while (n > 0) {
            for (int i = 0; i < m; i++) {
                if (arr[i][1] > max) {
                    max = arr[i][1];
                    index = i;
                    if (max == 10) break;
                }
            }
            if (arr[index][0] >= n) {
                R = n;
                n -= n;
                c += (R * arr[index][1]);
            } else {
                n -= arr[index][0];
                c += (arr[index][0] * arr[index][1]);
            }
            arr[index][1] = 0;
            max = 0;
        }
        System.out.println(c);
    }
}
