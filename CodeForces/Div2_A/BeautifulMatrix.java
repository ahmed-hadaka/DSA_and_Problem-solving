package Div2_A;
/*
 * code: http://codeforces.com/contest/263/problem/A
 *
 * took hint
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;

public class BeautifulMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int elem = 0, minMoves = 0;
        int[][] M = new int[5][5];

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                elem = sc.nextInt();
                if (elem == 1) {
                    minMoves = Math.abs(i - 2) + Math.abs(j - 2);
                    break;
                }
            }
            if (elem == 1)
                break;
        }
        System.out.println(minMoves);
    }
}
