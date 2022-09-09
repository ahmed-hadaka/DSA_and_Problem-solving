package Div2_A;

/*
 * code: http://codeforces.com/contest/268/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class Games {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        int[][] _2DArr = new int[n][2];
        for (int i = 0; i < n; i++) { // fill arr
            _2DArr[i][0] = sc.nextInt();
            _2DArr[i][1] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (_2DArr[i][0] == _2DArr[j][1])
                    count++;
            }
        }
        System.out.println(count);
    }
}
