package Div2_B;

/*
 * check : https://codeforces.com/contest/6/problem/B
 *
 * @ author: Ahmed_Hadaka
 * */

import java.util.Scanner;
import java.util.*;

public class President_Office {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Character> al = new ArrayList<>();
        char input;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arrIndex = new int[n * m * 2];
        int nElem = 0;
        char[][] arr = new char[n][m];
        char c = sc.next().charAt(0);
        for (int i = 0; i < n; i++) { // fill
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                input = str.charAt(j);
                arr[i][j] = input;
                if (input == c) { // store president's indices
                    arrIndex[nElem++] = i;
                    arrIndex[nElem++] = j;
                }
            }
        }

        for (int k = 0; k < nElem; k+=2) {
            int i = arrIndex[k];
            int j = arrIndex[k + 1];
            if ((i - 1) >= 0) { // up
                if (arr[i - 1][j] != '.' && arr[i - 1][j] != c && !al.contains(arr[i - 1][j]))
                    al.add(arr[i - 1][j]);
            }
            if ((i + 1) <= n - 1) {  // down
                if (arr[i + 1][j] != '.' && arr[i + 1][j] != c && !al.contains(arr[i + 1][j]))
                    al.add(arr[i + 1][j]);
            }
            if ((j + 1) <= m - 1) { // right
                if (arr[i][j + 1] != '.' && arr[i][j + 1] != c && !al.contains(arr[i][j + 1]))
                    al.add(arr[i][j + 1]);
            }
            if ((j - 1) >= 0) {  // left
                if (arr[i][j - 1] != '.' && arr[i][j - 1] != c && !al.contains(arr[i][j - 1]))
                    al.add(arr[i][j - 1]);
            }
        }
        System.out.println(al.size());
    }
}
