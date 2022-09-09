package Div2_A;

import java.util.Scanner;

/*
 * code: http://codeforces.com/contest/294/problem/A
 *
 * @ author: Ahmed_Hadaka
 * */
public class Shaass_and_Oskols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nW, j = 1, diedBirds, k = 0, ordW, ordB;
        nW = sc.nextInt();
        int[][] arr = new int[nW][2];
        for (int l = 0; l < nW; l++) { // fill first column
            arr[l][0] = j;
            j++;
        }
        for (int i = 0; i < nW; i++) { // fill second column
            arr[i][1] = sc.nextInt();
        }
        diedBirds = sc.nextInt();
        while (k < diedBirds) {
            ordW = sc.nextInt();
            ordB = sc.nextInt();
            if (nW == 1) {
                arr[ordW - 1][1] = 0;
                break;
            } else {
                if (ordW == 1)
                    arr[ordW][1] += arr[ordW - 1][1] - ordB; // down
                else if (ordW == nW)
                    arr[ordW - 2][1] += ordB - 1; // above
                else { // current
                    arr[ordW - 2][1] += ordB - 1;
                    arr[ordW][1] += arr[ordW - 1][1] - ordB;
                }
                arr[ordW - 1][1] = 0;
            }
            k++;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][1]);
        }
    }
}
